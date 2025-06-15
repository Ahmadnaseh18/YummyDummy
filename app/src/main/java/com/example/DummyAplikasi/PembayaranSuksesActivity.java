package com.example.DummyAplikasi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class PembayaranSuksesActivity extends AppCompatActivity {

    private ImageView iconSukses;
    private TextView txtSukses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran_sukses);

        iconSukses = findViewById(R.id.iconSukses);
        txtSukses = findViewById(R.id.txtSukses);

        Animation zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        iconSukses.startAnimation(zoomIn);
        txtSukses.startAnimation(fadeIn);

        // Kembali ke halaman utama dalam 3 detik (opsional)
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(PembayaranSuksesActivity.this, DaftarMakananActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }, 3000);
    }
}
