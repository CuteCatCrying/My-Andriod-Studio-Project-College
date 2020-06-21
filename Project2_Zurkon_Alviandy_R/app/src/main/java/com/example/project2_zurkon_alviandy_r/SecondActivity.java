package com.example.project2_zurkon_alviandy_r;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity implements AdapterView.OnItemSelectedListener {
    CheckBox cbJava, cbPhp, cbPython, cbPerl, cbRuby, cbXml;
    TextView out;
    Spinner spinnerSkill;
    Button btnProses;
    String[] progSkill = {"Basic", "Intermediate", "Advance"};
    StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        cbJava = (CheckBox) findViewById(R.id.checkbox_java);
        cbPhp = (CheckBox) findViewById(R.id.checkbox_php);
        cbPython = (CheckBox) findViewById(R.id.checkbox_python);
        cbPerl = (CheckBox) findViewById(R.id.checkbox_perl);
        cbRuby = (CheckBox) findViewById(R.id.checkbox_ruby);
        cbXml = (CheckBox) findViewById(R.id.checkbox_xml);
        out = (TextView)findViewById(R.id.txt_output);

        spinnerSkill = (Spinner)findViewById(R.id.skill_spinner);
        spinnerSkill.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, progSkill);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSkill.setAdapter(aa);

        btnProses = (Button) findViewById(R.id.btn_second_proses);
    }

    public void prosesSecondActivity(View v) {
        int gajiSkill = 0;
//        StringBuilder sb = new StringBuilder();

        if (cbJava.isChecked()) {
            sb.append("\nSkill java = Rp. 5 jt");
            gajiSkill += 5;
        }
        if (cbPhp.isChecked()) {
            sb.append("\nSkill php = Rp. 4 jt");
            gajiSkill += 4;
        }
        if (cbPython.isChecked()) {
            sb.append("\nSkill python = Rp. 6 jt");
            gajiSkill += 6;
        }
        if (cbPerl.isChecked()) {
            sb.append("\nSkill perl = Rp. 3 jt");
            gajiSkill += 3;
        }
        if (cbRuby.isChecked()) {
            sb.append("\nSkill ruby = Rp. 5 jt");
            gajiSkill += 5;
        }
        if (cbXml.isChecked()) {
            sb.append("\nSkill xml = Rp. 2 jt");
            gajiSkill += 2;
        }

        sb.append("\nTotal Gaji Diterima : " + "Rp. " + gajiSkill + " Jt");
//        Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();
        out.setText(sb.toString());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(), progSkill[position], Toast.LENGTH_LONG).show();
        sb.append("Skill : " + progSkill[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
