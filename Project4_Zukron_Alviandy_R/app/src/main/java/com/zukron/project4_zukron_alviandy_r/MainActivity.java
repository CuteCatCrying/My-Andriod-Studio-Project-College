package com.zukron.project4_zukron_alviandy_r;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText editNamaBarang, editJumlah, editHarga;
    Spinner spinSatuan;
    RadioButton rbCash, rbCredit, rbAtm;
    Button btnProses, btnListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNamaBarang = findViewById(R.id.edit_nama_barang);
        editJumlah = findViewById(R.id.edit_jumlah);
        editHarga = findViewById(R.id.edit_harga);
        spinSatuan = findViewById(R.id.spin_satuan);
        rbCash = findViewById(R.id.rb_cash);
        rbCredit = findViewById(R.id.rb_credit);
        rbAtm = findViewById(R.id.rb_atm);
        btnProses = findViewById(R.id.btn_proses);
        btnProses.setOnClickListener(new ProsesTransaksi());
        btnListView = findViewById(R.id.btn_list_activity);
        btnListView.setOnClickListener(new ProsesListActivity());
    }

    private class ProsesTransaksi implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String namaBarang = editNamaBarang.getText().toString();
            String satuan = spinSatuan.getSelectedItem().toString();
            String bayar = getRadioButtonBayar();
            int jumlah = Integer.parseInt(editJumlah.getText().toString());
            int harga = Integer.parseInt(editHarga.getText().toString());
            int total = jumlah * harga;

            StringBuilder sb = new StringBuilder();
            sb.append("Nama Barang : ").append(namaBarang);
            sb.append("\nSatuan : ").append(satuan);
            sb.append("\nJumlah : ").append(jumlah);
            sb.append("\nHarga : ").append(harga);
            sb.append("\nBayar : ").append(bayar);
            sb.append("\nTotal : ").append(total);

            Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();

            Intent intentHasil = new Intent(MainActivity.this, HasilActivity.class);
            intentHasil.putExtra("hasil", sb.toString());
            startActivity(intentHasil);
        }

        private String getRadioButtonBayar() {
            String result = "";

            if (rbCash.isChecked()) {
                result = rbCash.getText().toString();
            }

            if (rbCredit.isChecked()) {
                result = rbCredit.getText().toString();
            }

            if (rbAtm.isChecked()) {
                result = rbAtm.getText().toString();
            }
            return result;
        }
    }

    private class ProsesListActivity implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intentListView = new Intent(MainActivity.this, ListPahlawan.class);
            startActivity(intentListView);
        }
    }
}
