package com.zukron.project6_zukron_alviandy_r;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainRecCardActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rec_card);

        recyclerView = findViewById(R.id.rv_card);
        StoreData[] listStoreData = new StoreData[] {
                new StoreData("Ati Ampela Bumbu Rujan", R.drawable.logo1, "Bumbu rujan yang dibaluri Ampel"),
                new StoreData("Ayam Kecap", R.drawable.logo2, "Ayam yang dikecapi kecap"),
                new StoreData("Capcay", R.drawable.logo3, "Sayur yang dikuahi"),
                new StoreData("Olahan Cumi", R.drawable.logo4, "Cumi yang dipotong dikasih sambal"),
                new StoreData("Cumi Asin", R.drawable.logo5, "Cumi yang diasinkan"),
                new StoreData("Olahan Jamur", R.drawable.logo6, "Jamur yang diolah menjadi makanan"),
                new StoreData("Olahan Tahu", R.drawable.logo7, "Tahu yang diolah"),
                new StoreData("Olahan Telur", R.drawable.logo8, "Telur dari suatu hewan di masak"),
        };

        CardMenuAdapter adapter = new CardMenuAdapter(listStoreData);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
