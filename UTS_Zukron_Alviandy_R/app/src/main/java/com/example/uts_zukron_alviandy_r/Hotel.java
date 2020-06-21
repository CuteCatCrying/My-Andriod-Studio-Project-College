package com.example.uts_zukron_alviandy_r;

import android.os.Parcel;
import android.os.Parcelable;

public class Hotel implements Parcelable {
    private String jenisKamar;
    private String harga;
    private String luas;
    private int img;
    private String[] fasilitas;

    public Hotel(String jenisKamar, String harga, String luas, int img, String ...fasilitas) {
        this.jenisKamar = jenisKamar;
        this.harga = harga;
        this.luas = luas;
        this.img = img;
        this.fasilitas = fasilitas;
    }

    protected Hotel(Parcel in) {
        jenisKamar = in.readString();
        harga = in.readString();
        luas = in.readString();
        img = in.readInt();
        fasilitas = in.createStringArray();
    }

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel in) {
            return new Hotel(in);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };

    public String getJenisKamar() {
        return jenisKamar;
    }

    public String getHarga() {
        return harga;
    }

    public String getLuas() {
        return luas;
    }

    public int getImg() {
        return img;
    }

    public String[] getFasilitas() {
        return fasilitas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(jenisKamar);
        dest.writeString(harga);
        dest.writeString(luas);
        dest.writeInt(img);
        dest.writeStringArray(fasilitas);
    }
}
