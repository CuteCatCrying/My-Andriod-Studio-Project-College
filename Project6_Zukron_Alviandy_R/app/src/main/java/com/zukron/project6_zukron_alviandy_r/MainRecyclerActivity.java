package com.zukron.project6_zukron_alviandy_r;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainRecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btnToCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerItemMenu[] recyclerItemMenu = new RecyclerItemMenu[]{
                new RecyclerItemMenu("Ati Ampela Bumbu Rujan", R.drawable.logo1),
                new RecyclerItemMenu("Ayam Kecap", R.drawable.logo2),
                new RecyclerItemMenu("Capcay", R.drawable.logo3),
                new RecyclerItemMenu("Olahan Cumi", R.drawable.logo4),
                new RecyclerItemMenu("Cumi Asin", R.drawable.logo5),
                new RecyclerItemMenu("Olahan Jamur", R.drawable.logo6),
                new RecyclerItemMenu("Olahan Tahu", R.drawable.logo7),
                new RecyclerItemMenu("Olahan Telur", R.drawable.logo8)
        };
        RecyclerMenuAdapter adapter = new RecyclerMenuAdapter(recyclerItemMenu);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnToCardView = findViewById(R.id.btn_to_card_view);
        btnToCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainRecyclerActivity.this, MainRecCardActivity.class);
                startActivity(intent);
            }
        });
    }
}
