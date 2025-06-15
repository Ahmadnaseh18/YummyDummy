package com.example.DummyAplikasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class PembayaranActivity extends AppCompatActivity {

    TextView txtRingkasan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        txtRingkasan = findViewById(R.id.txtRingkasan);

        ArrayList<Makanan> makananList = getIntent().getParcelableArrayListExtra("selected_makanan");

        StringBuilder ringkasan = new StringBuilder();
        int total = 0;

        for (Makanan m : makananList) {
            ringkasan.append(m.getNama())
                    .append(" x ")
                    .append(m.getJumlah())
                    .append(" = ")
                    .append(hitungTotalHarga(m.getHarga(), m.getJumlah()))
                    .append("\n");

            total += hitungTotalHarga(m.getHarga(), m.getJumlah());
        }

        ringkasan.append("\nTotal Bayar: Rp").append(total);
        txtRingkasan.setText(ringkasan.toString());

        Button btnBayar = findViewById(R.id.btnBayar);
        btnBayar.setOnClickListener(v -> {
            Intent intent = new Intent(PembayaranActivity.this, PembayaranSuksesActivity.class);
            startActivity(intent);
            finish(); // Agar pengguna tidak kembali ke halaman ini saat menekan tombol back
        });

    }

    private int hitungTotalHarga(String hargaStr, int jumlah) {
        String angka = hargaStr.replaceAll("[^0-9]", "");
        int harga = Integer.parseInt(angka);
        return harga * jumlah;
    }
}
