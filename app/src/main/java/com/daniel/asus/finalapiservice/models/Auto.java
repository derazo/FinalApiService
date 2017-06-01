package com.daniel.asus.finalapiservice.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 31/05/2017.
 */

public class Auto {
    @SerializedName("clase")
    @Expose
    private String clase;
    @SerializedName("extranjero")
    @Expose
    private String extranjero;
    @SerializedName("oficial")
    @Expose
    private String oficial;
    @SerializedName("particular")
    @Expose
    private String particular;
    @SerializedName("publico")
    @Expose
    private String publico;
    @SerializedName("total")
    @Expose
    private String total;

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(String extranjero) {
        this.extranjero = extranjero;
    }

    public String getOficial() {
        return oficial;
    }

    public void setOficial(String oficial) {
        this.oficial = oficial;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public String getPublico() {
        return publico;
    }

    public void setPublico(String publico) {
        this.publico = publico;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
