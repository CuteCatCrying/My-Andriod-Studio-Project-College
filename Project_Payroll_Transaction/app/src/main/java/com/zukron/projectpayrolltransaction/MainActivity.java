package com.zukron.projectpayrolltransaction;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    DatePicker datePicker;
    EditText editIdKaryawan, editJumlahAnak;
    Spinner spinBagian, spinStatus, spinStatusKaryawan;
    CheckBox cbPokok, cbTunjanganAnak, cbTunjanganTransportasi, cbTunjanganMakan;
    RadioButton rbLakiLaki, rbPerempuan;
    Button btnProses;
    TextView tvOuput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDatePicker();
        addEditText();
        addSpinnerBagian();
        addSpinnerStatus();
        addSpinnerStatusKaryawan();
        addCheckBox();
        addRadioButton();
        addButtonProses();
        addTextViewOutput();

        /*
         * Gaji Pokok
         * HRD = 5000000
         * Produksi = 4000000
         * Accounting = 3000000
         * Surveyor = 2000000
         *
         * Tunjangan Anak = 100000 per anak
         * Tunjangan tranportasi = 200000
         * Tunjangan Makan = 100000
         *
         * */
    }

    private void addTextViewOutput() {
        tvOuput = (TextView)findViewById(R.id.tv_output);
    }

    private void addButtonProses() {
        btnProses = (Button) findViewById(R.id.btn_proses);
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                String tanggal = getDatePicker();
                String bagian = spinBagian.getSelectedItem().toString();
                String status = spinStatus.getSelectedItem().toString();
                String status_karyawan = spinStatusKaryawan.getSelectedItem().toString();
                String jenisKelamin = getJenisKelamin();

                double[] baseGajiPokok = {5000000, 4000000, 3000000, 2000000};
                double gajiPokok = baseGajiPokok[spinBagian.getSelectedItemPosition()];
                double jumlahAnak = Double.parseDouble(editJumlahAnak.getText().toString());
                double tunjanganAnak = jumlahAnak * getTunjanganAnak();
                double tunjanganTransportasi = getTunjanganTransportasi();
                double tunjanganMakan = getTunjanganMakan();
                double total, pajak, gaji;

                total = (gajiPokok + tunjanganAnak + tunjanganTransportasi + tunjanganMakan);
                pajak = total * 0.05;
                gaji = total - pajak;

                sb.append("\nTanggal : ").append(tanggal);
                sb.append("\nBagian : ").append(bagian);
                sb.append("\nStatus : ").append(status);
                sb.append("\nStatus Karyawan : ").append(status_karyawan);
                sb.append("\nJenis Kelamin : ").append(jenisKelamin);
                sb.append("\nTotal Gaji : ").append(total);
                sb.append("\nPajak 5% : ").append(pajak);
                sb.append("\nGaji Bersih : ").append(gaji);
                tvOuput.setText(sb.toString());
            }
        });
    }

    private String getDatePicker(){
        String hari = String.valueOf(datePicker.getDayOfMonth());
        String bulan = String.valueOf(datePicker.getMonth()+1);
        String tahun = String.valueOf(datePicker.getYear());

        return String.format("%s - %s - %s", hari, bulan, tahun);
    }

    private String getJenisKelamin(){
        if (rbLakiLaki.isChecked()){
            return rbLakiLaki.getText().toString();
        }

        if (rbPerempuan.isChecked()){
            return rbPerempuan.getText().toString();
        }

        return "";
    }

    private double getTunjanganMakan() {
        if (cbTunjanganMakan.isChecked()) {
            return 100000;
        }
        return 0;
    }

    private double getTunjanganTransportasi() {
        if (cbTunjanganTransportasi.isChecked()) {
            return 200000;
        }
        return 0;
    }

    private double getTunjanganAnak() {
        if (cbTunjanganAnak.isChecked()) {
            return 100000;
        }
        return 0;
    }

    private void addRadioButton() {
        rbLakiLaki = (RadioButton) findViewById(R.id.rb_laki_laki);
        rbLakiLaki.setChecked(true);
        rbPerempuan = (RadioButton) findViewById(R.id.rb_perempuan);
    }

    private void addCheckBox() {
        cbPokok = (CheckBox) findViewById(R.id.cb_pokok);
        cbPokok.setChecked(true);
        cbTunjanganAnak = (CheckBox) findViewById(R.id.cb_tunjangan_anak);
        cbTunjanganTransportasi = (CheckBox) findViewById(R.id.cb_tunjangan_transportasi);
        cbTunjanganMakan = (CheckBox) findViewById(R.id.cb_tunjangan_makan);
    }

    private void addSpinnerStatusKaryawan() {
        spinStatusKaryawan = (Spinner) findViewById(R.id.spin_status_karyawan);
        List<String> list = new ArrayList<>();
        list.add("Tetap");
        list.add("Kontrak");

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinStatusKaryawan.setAdapter(aa);
    }

    private void addSpinnerStatus() {
        spinStatus = (Spinner) findViewById(R.id.spin_status);
        List<String> list = new ArrayList<>();
        list.add("Menikah");
        list.add("Single");

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinStatus.setAdapter(aa);
    }

    private void addSpinnerBagian() {
        spinBagian = (Spinner) findViewById(R.id.spin_bagian);
        List<String> list = new ArrayList<>();
        list.add("HRD");
        list.add("Produksi");
        list.add("Acounting");
        list.add("Surveyor");

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinBagian.setAdapter(aa);
    }

    private void addEditText() {
        editIdKaryawan = (EditText) findViewById(R.id.edit_id_karyawan);
        editJumlahAnak = (EditText) findViewById(R.id.edit_jumlah_anak);
        editJumlahAnak.setText("0");
    }

    private void addDatePicker() {
        datePicker = (DatePicker) findViewById(R.id.date_picker);
    }
}
