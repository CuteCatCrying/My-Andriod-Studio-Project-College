package com.example.uts_zukron_alviandy_r;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailKamarActivity extends AppCompatActivity {
    TextView tvDetailJenisKamar, tvDetailHargaKamar, tvDetailUkuranKamar, tvDetailFasilitasKamar;
    ImageView ivDetailGambarKamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kamar);

        tvDetailJenisKamar = findViewById(R.id.tv_detail_jenis_kamar);
        tvDetailHargaKamar = findViewById(R.id.tv_detail_harga_kamar);
        tvDetailUkuranKamar = findViewById(R.id.tv_detail_ukuran_kamar);
        tvDetailFasilitasKamar = findViewById(R.id.tv_detail_fasilitas_kamar);
        ivDetailGambarKamar = findViewById(R.id.iv_detail_gambar_kamar);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setTitle("Zera Hotel");

        Hotel hotel = getIntent().getParcelableExtra("Hotel");
        if (hotel != null) {
            tvDetailJenisKamar.setText(hotel.getJenisKamar());
            tvDetailHargaKamar.setText(hotel.getHarga());
            tvDetailUkuranKamar.setText(hotel.getLuas());
            ivDetailGambarKamar.setImageResource(hotel.getImg());

            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            for (String s : hotel.getFasilitas()) {
                stringBuilder.append("\n").append(i).append(". ");;
                stringBuilder.append(s);
                i++;
            }
            tvDetailFasilitasKamar.setText(stringBuilder);
        }
    }
}
