package com.daniel.asus.finalapiservice.finalapi;

import com.daniel.asus.finalapiservice.models.Auto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASUS on 31/05/2017.
 */

public interface ApiService {
    @GET("rvmt-7x4r.json")
    Call<ArrayList<Auto>> obtenerListaAuto();
}



