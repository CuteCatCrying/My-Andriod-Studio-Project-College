package com.example.project3_zukron_alviandy_r;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class SpinnerItemListener implements AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // parent akan mengganti getApplicationContext()
        Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
