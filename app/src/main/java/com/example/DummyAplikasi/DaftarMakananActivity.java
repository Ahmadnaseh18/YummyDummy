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
        daftarMakanan.add(new Makanan("Sate Ayam", "Rp17.000", R.drawable.sate));
        daftarMakanan.add(new Makanan("Bakso", "Rp12.000", R.drawable.bakso));
        daftarMakanan.add(new Makanan("Mie Ayam", "Rp12.000", R.drawable.mie_ayam));
        daftarMakanan.add(new Makanan("Gado-Gado", "Rp10.000", R.drawable.gado_gado));
        daftarMakanan.add(new Makanan("Rendang", "Rp20.000", R.drawable.rendang));
        daftarMakanan.add(new Makanan("Soto Ayam", "Rp13.000", R.drawable.soto));
        daftarMakanan.add(new Makanan("Pempek", "Rp10.000", R.drawable.pempek));
        daftarMakanan.add(new Makanan("Lontong Sayur", "Rp10.000", R.drawable.lontong_sayur));
        daftarMakanan.add(new Makanan("Tahu Campur", "Rp10.000", R.drawable.tahu_campur));
        daftarMakanan.add(new Makanan("Nasi Putih", "Rp5.000", R.drawable.nasiputih));

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
