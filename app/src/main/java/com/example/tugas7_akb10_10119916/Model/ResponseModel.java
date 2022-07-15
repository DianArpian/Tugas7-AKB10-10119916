package com.example.tugas7_akb10_10119916.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

//10119199, Iqbal Fatur Nugraha, 06 Juli 2022

public class ResponseModel {
    @SerializedName("last_date")
    public String last_date;
    @SerializedName("current_data")
    public String current_data;
    @SerializedName("missing_data")
    public String missing_data;
    @SerializedName("tanpa_provinsi")
    public String tanpa_provinsi;
    @SerializedName("list_data")
    public List<KasusModel> data = new ArrayList<>();
}
