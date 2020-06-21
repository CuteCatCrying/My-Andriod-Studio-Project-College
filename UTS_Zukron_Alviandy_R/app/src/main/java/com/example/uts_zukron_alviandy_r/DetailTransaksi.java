package com.example.uts_zukron_alviandy_r;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailTransaksi extends AppCompatActivity {
    TextView tvId, tvCheckIn, tvJenisKamar, tvLamaMenginap, tvHargaSewa, tvJumlahOrang, tvTambahan, tvTotal, tvPajak, tvTotalBayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaksi);

        PemesananHotel pemesananHotel = getIntent().getParcelableExtra("PemesananHotel");
        System.out.println("Masuk");
        tvId = findViewById(R.id.tv_id);
        tvCheckIn = findViewById(R.id.tv_check_in);
        tvJenisKamar = findViewById(R.id.tv_jenis_kamar);
        tvLamaMenginap = findViewById(R.id.tv_lama_menginap);
        tvHargaSewa = findViewById(R.id.tv_harga_sewa);
        tvJumlahOrang = findViewById(R.id.tv_jumlah_orang);
        tvTambahan = findViewById(R.id.tv_tambahan);
        tvTotal = findViewById(R.id.tv_total);
        tvPajak = findViewById(R.id.tv_pajak);
        tvTotalBayar = findViewById(R.id.tv_total_bayar);

        if (pemesananHotel != null) {
            tvId.setText(pemesananHotel.getId());
            tvCheckIn.setText(pemesananHotel.getTanggalCheckIn());
            tvJenisKamar.setText(pemesananHotel.getJenisKamar());
            tvLamaMenginap.setText(pemesananHotel.getLamaMenginap());
            tvHargaSewa.setText(pemesananHotel.getHargaSewa());
            tvJumlahOrang.setText(pemesananHotel.getJumlahOrang());
            tvTambahan.setText(pemesananHotel.getTambahan());
            tvTotal.setText(pemesananHotel.getTotal());
            tvPajak.setText(pemesananHotel.getPajak());
            tvTotalBayar.setText(pemesananHotel.getTotalBayar());
        }
    }
}
