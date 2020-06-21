package com.example.uts_zukron_alviandy_r;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecCardActivity extends AppCompatActivity {
    RecyclerView rvHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_card);

        rvHotel = findViewById(R.id.rv_hotel);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setTitle("Zera Hotel");

        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(new Hotel("President Suite", "Harga : 1.500.000,-/nett", "Luas Kamar 8m x 7m", R.drawable.kamar1, "Hot and Cold Water", "Breakfast", "TV 40\"", "AC", "Free Wifi"));
        hotelList.add(new Hotel("Superior Suite", "Harga : 2.000.000,-/nett", "Luas Kamar 10 m x 10 m", R.drawable.kamar2, "Aroma Terapi", "Kulkas Pintu Dua", "Full AC Setiap Sudut", "Laundry"));
        hotelList.add(new Hotel("Executive Suite", "Harga : 1.700.000,-/nett", "Luas Kamar 7m x 8m", R.drawable.kamar3, "Kaca Besar", "Mejar Serba Guna", "TV 40\""));
        hotelList.add(new Hotel("Standard Suite", "Harga : 1.500.000,-/nett", "Luas Kamar 5 m x 5 m", R.drawable.kamar4, "Double Bed"));
        hotelList.add(new Hotel("Deluxe Suite", "Harga : 1.750.000,-/nett", "Luas Kamar 8 m x 8 m", R.drawable.kamar5, "Double Bed", "Aroma Terapi", "TV 40\""));

        RecCardAdapter recCardAdapter = new RecCardAdapter(hotelList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvHotel.setHasFixedSize(true);
        rvHotel.setAdapter(recCardAdapter);
        rvHotel.setLayoutManager(gridLayoutManager);
    }
}
