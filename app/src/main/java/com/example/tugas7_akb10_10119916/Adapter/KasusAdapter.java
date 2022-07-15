package com.example.tugas7_akb10_10119916.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas7_akb10_10119916.R;
import com.example.tugas7_akb10_10119916.Model.KasusModel;

import java.util.List;

public class KasusAdapter extends RecyclerView.Adapter {

    private final List dbList;
    Context context;

    public KasusAdapter(Context context, List dbList){
        this.context = context;
        this.dbList = dbList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new RowViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;

        int rowPos = rowViewHolder.getAdapterPosition();

        if (rowPos == 0) {
            rowViewHolder.provinsi.setBackgroundResource(R.drawable.table_header_bg);
            rowViewHolder.kasus.setBackgroundResource(R.drawable.table_header_bg);
            rowViewHolder.dirawat.setBackgroundResource(R.drawable.table_header_bg);
            rowViewHolder.sembuh.setBackgroundResource(R.drawable.table_header_bg);
            rowViewHolder.meinggal.setBackgroundResource(R.drawable.table_header_bg);

            rowViewHolder.provinsi.setText("Provinsi");
            rowViewHolder.kasus.setText("Kasus");
            rowViewHolder.dirawat.setText("Dirawat");
            rowViewHolder.sembuh.setText("Sembuh");
            rowViewHolder.meinggal.setText("Meninggal");
        }else {
            KasusModel modal = (KasusModel) dbList.get(rowPos - 1);

            rowViewHolder.provinsi.setBackgroundResource(R.drawable.table_bg);
            rowViewHolder.kasus.setBackgroundResource(R.drawable.table_bg);
            rowViewHolder.dirawat.setBackgroundResource(R.drawable.table_bg);
            rowViewHolder.sembuh.setBackgroundResource(R.drawable.table_bg);
            rowViewHolder.meinggal.setBackgroundResource(R.drawable.table_bg);

            rowViewHolder.provinsi.setText(modal.getProvinsi());
            rowViewHolder.kasus.setText(modal.getKasus());
            rowViewHolder.dirawat.setText(modal.getDirawat());
            rowViewHolder.sembuh.setText(modal.getSembuh());
            rowViewHolder.meinggal.setText(modal.getMeninggal());
        }
    }

    @Override
    public int getItemCount() {
        return dbList.size() +1;
    }

    public static class RowViewHolder extends RecyclerView.ViewHolder {
        TextView provinsi, kasus, dirawat, sembuh, meinggal;
        public RowViewHolder(@NonNull View view) {
            super(view);
            provinsi = view.findViewById(R.id.provinsi);
            kasus = view.findViewById(R.id.kasus);
            dirawat = view.findViewById(R.id.dirawat);
            sembuh = view.findViewById(R.id.sembuh);
            meinggal = view.findViewById(R.id.meinggal);
        }
    }
}
