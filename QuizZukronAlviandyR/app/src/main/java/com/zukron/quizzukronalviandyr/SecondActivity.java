package com.zukron.quizzukronalviandyr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    RecyclerView rvMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rvMakanan = findViewById(R.id.rv_makanan);
        Makanan[] listMakanan = new Makanan[]{
                new Makanan("01", "Ati Ampela Bumbu Rujan", R.drawable.logo1, "Bumbu rujan yang dibaluri Ampel", "Harga : Rp. 200000"),
                new Makanan("02", "Ayam Kecap", R.drawable.logo2, "Ayam yang dikecapi kecap", "Harga : Rp. 18000"),
                new Makanan("03", "Capcay", R.drawable.logo3, "Sayur yang dikuahi", "Harga : Rp. 15000"),
                new Makanan("04", "Olahan Cumi", R.drawable.logo4, "Cumi yang dipotong dikasih sambal", "Harga : Rp. 25000"),
                new Makanan("05", "Cumi Asin", R.drawable.logo5, "Cumi yang diasinkan", "Harga : Rp. 18000"),
                new Makanan("06", "Olahan Jamur", R.drawable.logo6, "Jamur yang diolah menjadi makanan", "Harga : Rp. 22000"),
                new Makanan("07", "Olahan Tahu", R.drawable.logo7, "Tahu yang diolah", "Harga : Rp. 13000"),
                new Makanan("08", "Olahan Telur", R.drawable.logo8, "Telur dari suatu hewan di masak", "Harga : Rp. 20000"),
        };
        RecyclerAdapter adapter = new RecyclerAdapter(listMakanan);
        rvMakanan.setHasFixedSize(true);
        rvMakanan.setLayoutManager(new LinearLayoutManager(this));
        rvMakanan.setAdapter(adapter);
    }
}
