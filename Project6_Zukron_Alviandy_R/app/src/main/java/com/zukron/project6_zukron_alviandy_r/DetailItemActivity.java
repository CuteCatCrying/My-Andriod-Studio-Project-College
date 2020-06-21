package com.zukron.project6_zukron_alviandy_r;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailItemActivity extends AppCompatActivity {
    ImageView imgDetail;
    TextView titleDetail;
    TextView descriptionDetail;
    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        imgDetail = findViewById(R.id.img_detail);
        titleDetail = findViewById(R.id.title_detail);
        descriptionDetail = findViewById(R.id.description_detail);
        toolbar = getSupportActionBar();

        StoreData storeData = getIntent().getParcelableExtra("storeData");
        if (storeData != null) {
            toolbar.setTitle(storeData.getItemTitle());
            imgDetail.setImageResource(storeData.getItemImg());
            titleDetail.setText(storeData.getItemTitle());
            descriptionDetail.setText(storeData.getItemDetail());
        }
    }
}
