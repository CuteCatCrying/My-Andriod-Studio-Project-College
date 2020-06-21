package com.zukron.project5_zukron_alviandy_r;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondGridActivity extends AppCompatActivity {
    ImageView ivFullImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_grid);

        ivFullImage = (ImageView)findViewById(R.id.iv_full_image);
        int image = getIntent().getIntExtra("image", 0);
//        int image = (int) getIntent().getSerializableExtra("image");
        ivFullImage.setImageResource(image);

    }
}
