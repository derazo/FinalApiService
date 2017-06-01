package com.daniel.asus.finalapiservice;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daniel.asus.finalapiservice.models.Auto;

import java.util.ArrayList;

/**
 * Created by ASUS on 31/05/2017.
 */

public class ListaAutoAdapter extends RecyclerView.Adapter<ListaAutoAdapter.ViewHolder> {
    private ArrayList<Auto> dataset;

    private Context context;

    public ListaAutoAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_auto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Auto a = dataset.get(position);
        holder.clase.setText(a.getClase());
        holder.numero.setText(a.getExtranjero().toString());
        holder.oficial.setText(a.getOficial().toString());
        holder.particular.setText(a.getParticular().toString());
        holder.publico.setText(a.getPublico().toString());
        holder.total.setText(a.getTotal().toString());


    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void adicionarListaAuto(ArrayList<Auto> listaAuto) {
        dataset.addAll(listaAuto);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView clase;
        private TextView numero;
        private TextView oficial;
        private TextView particular;
        private TextView publico;
        private TextView total;

        public ViewHolder(View itemView) {
            super(itemView);


            clase = (TextView) itemView.findViewById(R.id.clase);
            numero= (TextView) itemView.findViewById(R.id.numero);
            oficial=(TextView) itemView.findViewById(R.id.oficial);
            particular=(TextView) itemView.findViewById(R.id.particular);
            publico=(TextView) itemView.findViewById(R.id.publico);
            total=(TextView) itemView.findViewById(R.id.total);
        }
    }
}
