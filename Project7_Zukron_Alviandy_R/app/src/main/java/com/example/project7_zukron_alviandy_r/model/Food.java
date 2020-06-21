package com.example.project7_zukron_alviandy_r.model;

public class Food {
    private int id;
    private String nama;
    private String keterangan;
    private double harga;
    private double promo;
    private String gambar;

    public Food(int id, String nama, String keterangan, double harga, double promo, String gambar) {
        this.id = id;
        this.nama = nama;
        this.keterangan = keterangan;
        this.harga = harga;
        this.promo = promo;
        this.gambar = gambar;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public double getHarga() {
        return harga;
    }

    public double getPromo() {
        return promo;
    }

    public String getGambar() {
        return gambar;
    }
}
