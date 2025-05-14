package com.example.DummyAplikasi;

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

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_login); // Pastikan ini layout login kamu

        // Inisialisasi komponen
        etEmail = findViewById(R.id.emailInput);
        etPassword = findViewById(R.id.passwordInput);
        btnLogin = findViewById(R.id.loginButton);

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            Log.d(TAG, "Email: " + email + ", Password: " + password);
            Toast.makeText(LoginActivity.this, "Memproses login...", Toast.LENGTH_SHORT).show();

            // Panggil API
            ApiInterface api = ApiClient.getRetrofitInstance().create(ApiInterface.class);
            Call<ResponseBody> call = api.login(email, password);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        if (response.isSuccessful() && response.body() != null) {
                            String result = response.body().string();
                            Log.d(TAG, "Login sukses: " + result);
                            Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                            // Pindah ke ActivityMenu
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Log.e(TAG, "Login gagal, response code: " + response.code());
                            Toast.makeText(LoginActivity.this, "Login gagal. Cek email/password.", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "Exception parsing response: " + e.getMessage());
                        Toast.makeText(LoginActivity.this, "Kesalahan saat login", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.e(TAG, "Koneksi gagal: " + t.getMessage());
                    Toast.makeText(LoginActivity.this, "Gagal koneksi ke server.", Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}
