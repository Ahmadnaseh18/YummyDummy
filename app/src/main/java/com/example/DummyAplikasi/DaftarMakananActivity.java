package com.example.DummyAplikasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DaftarMakananActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MakananAdapter adapter;
    private List<Makanan> daftarMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_makanan); // layout berisi RecyclerView

        recyclerView = findViewById(R.id.recyclerMakanan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        daftarMakanan = new ArrayList<>();
        daftarMakanan.add(new Makanan("Nasi Goreng", "Rp12.000", R.drawable.nasi));
        daftarMakanan.add(new Makanan("Sate Ayam", "Rp15.000", R.drawable.nasi));
        daftarMakanan.add(new Makanan("Bakso", "Rp10.000", R.drawable.nasi));
        daftarMakanan.add(new Makanan("Mie Ayam", "Rp11.000", R.drawable.nasi));
        daftarMakanan.add(new Makanan("Gado-Gado", "Rp9.000", R.drawable.nasi));
        daftarMakanan.add(new Makanan("Rendang", "Rp20.000", R.drawable.nasi));
        daftarMakanan.add(new Makanan("Soto Ayam", "Rp13.000", R.drawable.nasi));
        daftarMakanan.add(new Makanan("Pempek", "Rp14.000", R.drawable.nasi));
        daftarMakanan.add(new Makanan("Lontong Sayur", "Rp10.000", R.drawable.nasi));
        daftarMakanan.add(new Makanan("Tahu Campur", "Rp8.000", R.drawable.nasi));
        daftarMakanan.add(new Makanan("Nasi Uduk", "Rp9.000", R.drawable.nasi));

        adapter = new MakananAdapter(daftarMakanan);
        recyclerView.setAdapter(adapter);

        Button btnCheckout = findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(v -> {
            ArrayList<Makanan> selectedMakanan = new ArrayList<>();
            for (Makanan makanan : daftarMakanan) {
                if (makanan.getJumlah() > 0) {
                    selectedMakanan.add(makanan);
                }
            }

            Intent intent = new Intent(DaftarMakananActivity.this, PembayaranActivity.class);
            intent.putParcelableArrayListExtra("selected_makanan", selectedMakanan);
            startActivity(intent);
        });
    }
}
