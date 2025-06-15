package com.example.DummyAplikasi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MakananViewHolder> {

    private List<Makanan> listMakanan;

    public MakananAdapter(List<Makanan> listMakanan) {
        this.listMakanan = listMakanan;
    }

    public static class MakananViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMakanan;
        TextView txtNamaMakanan, txtHargaMakanan, txtJumlah;
        Button btnPlus, btnMinus;

        public MakananViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMakanan = itemView.findViewById(R.id.imgMakanan);
            txtNamaMakanan = itemView.findViewById(R.id.txtNamaMakanan);
            txtHargaMakanan = itemView.findViewById(R.id.txtHargaMakanan);
            txtJumlah = itemView.findViewById(R.id.txtJumlah);
            btnPlus = itemView.findViewById(R.id.btnPlus);
            btnMinus = itemView.findViewById(R.id.btnMinus);
        }
    }

    @NonNull
    @Override
    public MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_makanan, parent, false);
        return new MakananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananViewHolder holder, int position) {
        Makanan makanan = listMakanan.get(position);
        holder.imgMakanan.setImageResource(makanan.getGambarResId());
        holder.txtNamaMakanan.setText(makanan.getNama());
        holder.txtHargaMakanan.setText(makanan.getHarga());

        final int[] jumlah = {0};
        holder.txtJumlah.setText(String.valueOf(jumlah[0]));

        holder.btnPlus.setOnClickListener(v -> {
            jumlah[0]++;
            holder.txtJumlah.setText(String.valueOf(jumlah[0]));
            makanan.setJumlah(jumlah[0]);
        });

        holder.btnMinus.setOnClickListener(v -> {
            if (jumlah[0] > 0) jumlah[0]--;
            holder.txtJumlah.setText(String.valueOf(jumlah[0]));
            makanan.setJumlah(jumlah[0]);
        });
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }
}

