package com.example.DummyAplikasi;

import android.os.Parcel;
import android.os.Parcelable;

public class Makanan implements Parcelable {
    private String nama;
    private String harga;
    private int gambarResId;
    private int jumlah = 0;

    public Makanan(String nama, String harga, int gambarResId) {
        this.nama = nama;
        this.harga = harga;
        this.gambarResId = gambarResId;
    }

    protected Makanan(Parcel in) {
        nama = in.readString();
        harga = in.readString();
        gambarResId = in.readInt();
        jumlah = in.readInt();
    }

    public static final Creator<Makanan> CREATOR = new Creator<Makanan>() {
        @Override
        public Makanan createFromParcel(Parcel in) {
            return new Makanan(in);
        }

        @Override
        public Makanan[] newArray(int size) {
            return new Makanan[size];
        }
    };

    public String getNama() { return nama; }
    public String getHarga() { return harga; }
    public int getGambarResId() { return gambarResId; }
    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(harga);
        parcel.writeInt(gambarResId);
        parcel.writeInt(jumlah);
    }
}

