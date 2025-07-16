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
        daftarMakanan.add(new Makanan("Nasi Putih", "Rp5.000", R.drawable.nasi_putih));
        daftarMakanan.add(new Makanan("Ayam Goreng", "Rp10.000", R.drawable.ayam_goreng));
        daftarMakanan.add(new Makanan("Ayam Balado", "Rp11.000", R.drawable.ayam_balado));
        daftarMakanan.add(new Makanan("Telur Dadar", "Rp6.000", R.drawable.telur_dadar));
        daftarMakanan.add(new Makanan("Telur Balado", "Rp7.000", R.drawable.telur_balado));
        daftarMakanan.add(new Makanan("Ikan Goreng", "Rp8.000", R.drawable.ikan_goreng));
        daftarMakanan.add(new Makanan("Tahu Goreng", "Rp3.000", R.drawable.tahu_goreng));
        daftarMakanan.add(new Makanan("Telur Balado", "Rp7.000", R.drawable.telur_balado));
        daftarMakanan.add(new Makanan("Perkedel", "Rp4.000", R.drawable.perkedel));
        daftarMakanan.add(new Makanan("Rendang", "Rp13.000", R.drawable.rendang));
        daftarMakanan.add(new Makanan("Semur Jengkol", "Rp8.000", R.drawable.jengkol));
        daftarMakanan.add(new Makanan("Sayur Asem", "Rp5.000", R.drawable.sayur_asem));
        daftarMakanan.add(new Makanan("Ati Ampela Balado", "Rp9.000", R.drawable.ati_ampela_balado));
        daftarMakanan.add(new Makanan("Sayur Lodeh", "Rp5.000", R.drawable.sayur_lodeh));
        daftarMakanan.add(new Makanan("Tumis Kangkung", "Rp4.000", R.drawable.tumis_kangkung));
        daftarMakanan.add(new Makanan("Capcay", "Rp6.000", R.drawable.capcay));
        daftarMakanan.add(new Makanan("Es Teh", "Rp4.000", R.drawable.esteh));
        daftarMakanan.add(new Makanan("Air Mineral", "Rp3.000", R.drawable.air_mineral));
        daftarMakanan.add(new Makanan("Es Jeruk", "Rp4.000", R.drawable.es_jeruk));

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
