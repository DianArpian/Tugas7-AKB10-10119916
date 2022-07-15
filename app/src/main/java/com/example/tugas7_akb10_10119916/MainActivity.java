package com.example.tugas7_akb10_10119916;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tugas7_akb10_10119916.API.ApiEndPoint;
import com.example.tugas7_akb10_10119916.API.ApiService;
import com.example.tugas7_akb10_10119916.Adapter.KasusAdapter;
import com.example.tugas7_akb10_10119916.Model.KasusModel;
import com.example.tugas7_akb10_10119916.Model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private KasusAdapter kasusAdapter;
    private List<KasusModel> dbItems = new ArrayList<>();

    @BindView(R.id.recyclerViewBalita)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        kasusAdapter = new KasusAdapter(this, dbItems);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(kasusAdapter);

        loadDataBalita();
    }

    private void loadDataBalita() {

        //Declare Retrofit
        ApiService api = ApiEndPoint.getClient().create(ApiService.class);

        Call<ResponseModel> call = api.getKasus();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                dbItems = response.body().data;
                System.out.println("STATUS data "+dbItems);
                kasusAdapter = new KasusAdapter(MainActivity.this, dbItems);
                recyclerView.setAdapter(kasusAdapter);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Oops, your connection is bad! ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}