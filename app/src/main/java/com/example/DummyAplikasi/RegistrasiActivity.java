package com.example.DummyAplikasi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrasiActivity extends AppCompatActivity {

    private static final String TAG = "RegistrasiActivity";

    private EditText etNama, etEmail, etPassword;
    private Button btnRegister, btnKembali;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_register); // Pastikan ini sesuai dengan layout XML kamu

        // Inisialisasi komponen UI
        etNama = findViewById(R.id.fullNameInput);
        etEmail = findViewById(R.id.emailInput);
        etPassword = findViewById(R.id.passwordInput);
        btnRegister = findViewById(R.id.signupButton);
        btnKembali = findViewById(R.id.backButton);

        // Tombol Registrasi
        btnRegister.setOnClickListener(v -> {
            String nama = etNama.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (nama.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(RegistrasiActivity.this, "Semua field harus diisi", Toast.LENGTH_SHORT).show();
                return;
            }

            // Panggil API untuk registrasi
            ApiInterface api = ApiClient.getRetrofitInstance().create(ApiInterface.class);
            Call<ResponseBody> call = api.register(nama, email, password);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        if (response.isSuccessful() && response.body() != null) {
                            String result = response.body().string();
                            Log.d(TAG, "Registrasi berhasil: " + result);
                            Toast.makeText(RegistrasiActivity.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();

                            // Kembali ke halaman login
                            Intent intent = new Intent(RegistrasiActivity.this, MenuLoginRegisterActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Log.e(TAG, "Registrasi gagal. Kode: " + response.code());
                            Toast.makeText(RegistrasiActivity.this, "Registrasi gagal. Coba lagi.", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(RegistrasiActivity.this, "Terjadi kesalahan saat memproses.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.e(TAG, "Gagal koneksi: " + t.getMessage());
                    Toast.makeText(RegistrasiActivity.this, "Tidak dapat terhubung ke server.", Toast.LENGTH_SHORT).show();
                }
            });
        });

        // Tombol Kembali ke menu login/register
        btnKembali.setOnClickListener(v -> {
            Intent intent = new Intent(RegistrasiActivity.this, MenuLoginRegisterActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
