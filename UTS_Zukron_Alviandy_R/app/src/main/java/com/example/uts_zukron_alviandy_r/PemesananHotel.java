package com.example.uts_zukron_alviandy_r;

import android.os.Parcel;
import android.os.Parcelable;

public class PemesananHotel implements Parcelable{
    private String id;
    private String tanggalCheckIn;
    private String jenisKamar;
    private String lamaMenginap;
    private String hargaSewa;
    private String jenisKelamin;
    private String jumlahOrang;
    private String tambahan;
    private String total;
    private String pajak;
    private String totalBayar;

    public PemesananHotel(){}

    protected PemesananHotel(Parcel in) {
        id = in.readString();
        tanggalCheckIn = in.readString();
        jenisKamar = in.readString();
        lamaMenginap = in.readString();
        hargaSewa = in.readString();
        jenisKelamin = in.readString();
        jumlahOrang = in.readString();
        tambahan = in.readString();
        total = in.readString();
        pajak = in.readString();
        totalBayar = in.readString();
    }

    public static final Creator<PemesananHotel> CREATOR = new Creator<PemesananHotel>() {
        @Override
        public PemesananHotel createFromParcel(Parcel in) {
            return new PemesananHotel(in);
        }

        @Override
        public PemesananHotel[] newArray(int size) {
            return new PemesananHotel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    public void setTanggalCheckIn(String tanggalCheckIn) {
        this.tanggalCheckIn = tanggalCheckIn;
    }

    public String getJenisKamar() {
        return jenisKamar;
    }

    public void setJenisKamar(String jenisKamar) {
        this.jenisKamar = jenisKamar;
    }

    public String getLamaMenginap() {
        return lamaMenginap;
    }

    public void setLamaMenginap(String lamaMenginap) {
        this.lamaMenginap = lamaMenginap;
    }

    public String getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(String hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJumlahOrang() {
        return jumlahOrang;
    }

    public void setJumlahOrang(String jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

    public String getTambahan() {
        return tambahan;
    }

    public void setTambahan(String tambahan) {
        this.tambahan = tambahan;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPajak() {
        return pajak;
    }

    public void setPajak(String pajak) {
        this.pajak = pajak;
    }

    public String getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(String totalBayar) {
        this.totalBayar = totalBayar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(tanggalCheckIn);
        dest.writeString(jenisKamar);
        dest.writeString(lamaMenginap);
        dest.writeString(hargaSewa);
        dest.writeString(jenisKelamin);
        dest.writeString(jumlahOrang);
        dest.writeString(tambahan);
        dest.writeString(total);
        dest.writeString(pajak);
        dest.writeString(totalBayar);
    }
}
