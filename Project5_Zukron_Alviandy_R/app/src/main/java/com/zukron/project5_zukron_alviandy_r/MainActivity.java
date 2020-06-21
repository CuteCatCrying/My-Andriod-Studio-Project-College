package com.zukron.project5_zukron_alviandy_r;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
    String[] progList = {
            "PHP", "JavaScript", "TypeScript", "VisualBasic",
            "Python", "Java", "C", "C++", "C#", "Ruby", "Swift", "Delphi"};
    int[] imgList = {
            R.drawable.logo1, R.drawable.logo2, R.drawable.logo3, R.drawable.logo4,
            R.drawable.logo5, R.drawable.logo6, R.drawable.logo7, R.drawable.logo8,
            R.drawable.logo9, R.drawable.logo10, R.drawable.logo11, R.drawable.logo12};
    Button btnGallery;
    ListView lvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvData = (ListView)findViewById(R.id.lv_data);
        lvData.setAdapter(new ProgrammingAdapter(MainActivity.this, progList, imgList));

        btnGallery = (Button)findViewById(R.id.btn_gallery);
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GaleryImageActivity.class);
                startActivity(intent);
            }
        });
    }
}
