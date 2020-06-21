package com.zukron.project5_zukron_alviandy_r;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GaleryImageActivity extends AppCompatActivity {
    GridView gridView;
    int[] imgList = {
            R.drawable.logo1, R.drawable.logo2, R.drawable.logo3, R.drawable.logo4,
            R.drawable.logo5, R.drawable.logo6, R.drawable.logo7, R.drawable.logo8,
            R.drawable.logo9, R.drawable.logo10, R.drawable.logo11, R.drawable.logo12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery_image);

        gridView = findViewById(R.id.simple_grid_view);
        gridView.setAdapter(new GridAdapter(GaleryImageActivity.this, imgList));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GaleryImageActivity.this, SecondGridActivity.class);
                intent.putExtra("image", imgList[position]);
                startActivity(intent);
            }
        });
    }
}
