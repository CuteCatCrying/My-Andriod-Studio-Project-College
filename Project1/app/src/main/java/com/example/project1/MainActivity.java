package com.example.project1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText editNameMhs, editClassMhs;
    Button btnSubmit;
    TextView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNameMhs = (EditText)findViewById(R.id.edit_name);
        editClassMhs = (EditText)findViewById(R.id.edit_class);
        btnSubmit = (Button)findViewById(R.id.btn_submit);
        out = (TextView)findViewById(R.id.txt_output);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String outputName = "Nama Mahasiswa : " + editNameMhs.getText().toString();
        String outputClass = " Kelas : " + editClassMhs.getText().toString();
        String result = outputName + outputClass;

        out.setText(result);

    }
}
