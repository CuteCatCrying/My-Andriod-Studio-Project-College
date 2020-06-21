package com.zukron.project4_zukron_alviandy_r;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HasilActivity extends Activity {
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        Intent intent = getIntent();
        String text = String.valueOf(getIntent().getSerializableExtra("hasil"));

//        String text = getIntent().getStringExtra("hasil");

        tvHasil = findViewById(R.id.tv_hasil);
        tvHasil.setText(text);
//        tvHasil.setText(intent.toString());
    }
}
