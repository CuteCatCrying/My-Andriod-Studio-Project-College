package com.example.project2_zurkon_alviandy_r;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText inputSatuan, inputBeli;
    TextView txtOutTransaksi;
    Button btnProses, btnNext;
    RadioButton rbKg, rbGram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputSatuan = (EditText) findViewById(R.id.edit_satuan);
        inputBeli = (EditText) findViewById(R.id.edit_beli);

        txtOutTransaksi = (TextView) findViewById(R.id.txt_transaksi);

        rbKg = (RadioButton) findViewById(R.id.rbKg);
        rbKg.setOnClickListener(this);
        rbGram = (RadioButton) findViewById(R.id.rbGram);
        rbGram.setOnClickListener(this);
        btnProses = (Button) findViewById(R.id.btn_proses);
        btnProses.setOnClickListener(this);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.rbKg):
            case (R.id.rbGram):
            case (R.id.btn_proses):
                double pajak, total;
                double diskon = 0.0;
                double totalBayar;
                String radioButton = "";

                double satuan = Double.parseDouble(inputSatuan.getText().toString());
                double beli = Double.parseDouble(inputBeli.getText().toString());

                pajak = (satuan * beli) * 0.05;
                total = (satuan * beli) + pajak;

                if (beli > 10) {
                    diskon = total * 0.1;
                }

                totalBayar = total - diskon;

                // Get Radio Button
                if (rbKg.isChecked()) {
                    radioButton = rbKg.getText().toString();
                }
                if (rbGram.isChecked()) {
                    radioButton = rbGram.getText().toString();
                }

                txtOutTransaksi.setText("Pembelian Barang :\nPajak 5%\t\t: " + pajak + "\nTotal\t\t\t: " + total + "\nDiskon 10%\t: " + diskon + "\nTotal Bayar\t: " + totalBayar + "\nTipe Satuan\t: " + radioButton);
                break;

            case (R.id.btn_next):
                Intent intentNext = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentNext);
                break;
        }

    }


//    public void btnProsesAction(View v) {
//        double pajak, total;
//        double diskon = 0.0;
//        double totalBayar;
//
//        double satuan = Double.parseDouble(inputSatuan.getText().toString());
//        double beli = Double.parseDouble(inputBeli.getText().toString());
//
//        totalBayar = (satuan*beli);
//        pajak = totalBayar * 0.05;
//        total = totalBayar + pajak;
//
//        if (beli > 10){
//            diskon = total * 0.1;
//        }
//
//        totalBayar = total - diskon;
//
//
//        txtOutTransaksi.setText("Pembelian Barang :\nPajak 5%\t\t: " + pajak + "\nTotal\t\t\t: " + total + "\nDiskon 10%\t: " + diskon + "\nTotal Bayar\t: " + totalBayar);
//    }
}
