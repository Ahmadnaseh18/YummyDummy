package com.example.DummyAplikasi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    // Endpoint untuk registrasi (jika belum ada)
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> register(
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("password") String password
    );

    // ✅ Endpoint untuk login
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login(
            @Field("email") String email,
            @Field("password") String password
    );
}
