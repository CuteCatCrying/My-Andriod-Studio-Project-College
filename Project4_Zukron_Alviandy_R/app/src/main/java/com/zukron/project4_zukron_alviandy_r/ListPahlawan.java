package com.zukron.project4_zukron_alviandy_r;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListPahlawan extends AppCompatActivity {
    ListView listPahlawan;
    String[] programmingLanguage = {"Java", "C", "C++", "C#", "Python", "PHP", "JavaScript", "Ruby", "Kotlin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pahlawan);

        listPahlawan = findViewById(R.id.lv_pahlawan);
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, programmingLanguage);
        listPahlawan.setAdapter(aa);
        listPahlawan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String listItem = parent.getItemAtPosition(position).toString();

                Toast.makeText(ListPahlawan.this, listItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
