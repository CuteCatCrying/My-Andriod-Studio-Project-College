package com.example.calcchellenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Angka> listAngka = new ArrayList<>();

        int range1 = (20 - 1) + 1;
                Random random = new Random();
        int range2 = (10 - 1) + 1;

        for (int i=0; i<10; i++) {
            int angka1 = random.nextInt(range1);
            int angka2 = random.nextInt(range2);

            Angka angka = new Angka(angka1, angka2);
            listAngka.add(angka);
        }

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(listAngka);
        final List<Integer> listHasil = recyclerAdapter.getListHasil();
        Button btnCekResult = findViewById(R.id.btn_check_result);
        btnCekResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.valueOf(listHasil.get(0)), Toast.LENGTH_SHORT).show();
            }
        });

        rvData = findViewById(R.id.rv_data);
        rvData.setHasFixedSize(true);
        rvData.setLayoutManager(new LinearLayoutManager(this));
        rvData.setAdapter(recyclerAdapter);
    }
}
