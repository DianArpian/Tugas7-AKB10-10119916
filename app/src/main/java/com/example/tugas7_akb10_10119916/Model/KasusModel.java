package com.example.tugas7_akb10_10119916.Model;

import com.google.gson.annotations.SerializedName;

//10119199, Iqbal Fatur Nugraha, 06 Juli 2022

public class KasusModel {

    @SerializedName("key")
    public String provinsi;
    @SerializedName("jumlah_kasus")
    public String kasus;
    @SerializedName("jumlah_dirawat")
    public String dirawat;
    @SerializedName("jumlah_sembuh")
    public String sembuh;
    @SerializedName("jumlah_meninggal")
    public String meinggal;

    public String getProvinsi(){return provinsi;}
    public String getKasus(){return kasus;}
    public String getDirawat(){return dirawat;}
    public String getSembuh(){return sembuh;}
    public String getMeninggal(){return meinggal;}
}
