package com.example.project3_zukron_alviandy_r;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    public Spinner spinner1, spinner2;
    public Button btnSubmit, btnDatePicker, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSpinnerActionListener();
        addSpinner2Action();
        addBtnSubmitAction();
        addBtnDatePicker();
        addBtnExit();
    }

    private void addBtnExit() {
        final AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setIcon(R.drawable.exit);
        ab.setTitle(R.string.exit);
        ab.setMessage("Ingin Keluar ? ");
        ab.setCancelable(false);
        ab.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        ab.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        btnExit = (Button)findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog ad = ab.create();
                ad.show();
            }
        });
    }

    private void addBtnDatePicker() {
        btnDatePicker = (Button)findViewById(R.id.btn_date_picker);
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDate = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentDate);
            }
        });
    }

    private void addSpinnerActionListener() {
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new SpinnerItemListener());
    }

    private void addSpinner2Action() {
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        List<String> listItemSpin2 = new ArrayList<String>();
        listItemSpin2.add("Java");
        listItemSpin2.add("PHP");
        listItemSpin2.add("C");
        listItemSpin2.add("Pascal");
        listItemSpin2.add("SmallTalk");
        listItemSpin2.add("Ruby");

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listItemSpin2);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(aa);
    }

    private void addBtnSubmitAction() {
        btnSubmit = (Button)findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Aksi spinner Job Skill : " + String.valueOf(spinner1.getSelectedItem()) + "\nAksi spinner 2 : " + String.valueOf(spinner2.getSelectedItem()), Toast.LENGTH_LONG).show();

            }
        });
    }
}
