package com.daniel.asus.finalapiservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.daniel.asus.finalapiservice.finalapi.ApiService;
import com.daniel.asus.finalapiservice.models.Auto;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private static final String TAG = "POKEDEX";
    private RecyclerView recyclerView;
    private int offset;
    private boolean aptoParaCargar;
    private ListaAutoAdapter listaAutoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaAutoAdapter = new ListaAutoAdapter(this);
        recyclerView.setAdapter(listaAutoAdapter);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            offset += 20;
                            obtenerLista();
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar = true;
        offset = 0;
        obtenerLista();
    }

    private void obtenerLista() {

        ApiService service = retrofit.create(ApiService.class);
        Call<ArrayList<Auto>> autoRespuestaCall = service.obtenerListaAuto();

        autoRespuestaCall.enqueue(new Callback<ArrayList<Auto>>() {
            @Override
            public void onResponse(Call<ArrayList<Auto>> call, Response<ArrayList<Auto>> response) {
                if(response.isSuccessful()){
                    ArrayList lista = response.body();
                    listaAutoAdapter.adicionarListaAuto(lista);
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Auto>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });

    }
}
