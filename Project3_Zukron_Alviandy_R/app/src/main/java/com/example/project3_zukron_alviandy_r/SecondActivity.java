package com.example.project3_zukron_alviandy_r;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class SecondActivity extends Activity {
    DatePicker date;
    TimePicker time;
    Button btnDate, btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        addBtnDateChooser();
        addBtnTimeChooser();
    }

    private void addBtnTimeChooser() {
        time = (TimePicker)findViewById(R.id.time_picker);

        btnTime = (Button)findViewById(R.id.btn_time);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(SecondActivity.this, hourOfDay + " " + minute, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void addBtnDateChooser() {
        date = (DatePicker)findViewById(R.id.date_picker);

        btnDate = (Button)findViewById(R.id.btn_date);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] bulan = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                String day = "Tanggal : " + date.getDayOfMonth();
                String month = "Bulan : " + bulan[date.getMonth()];
                String year = "Tahun : " + date.getYear();

                Toast.makeText(SecondActivity.this, day + "\n" + month + "\n" + year, Toast.LENGTH_LONG).show();
            }
        });
    }
}
