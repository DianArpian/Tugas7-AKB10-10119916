package com.example.tugas7_akb10_10119916.API;

import com.example.tugas7_akb10_10119916.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("prov.json")
    Call<ResponseModel> getKasus();
}
