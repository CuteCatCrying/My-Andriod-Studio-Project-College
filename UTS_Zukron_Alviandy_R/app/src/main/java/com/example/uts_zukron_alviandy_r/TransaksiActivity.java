package com.example.uts_zukron_alviandy_r;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class TransaksiActivity extends AppCompatActivity {
    EditText editId, editLamaMenginap, editHargaSewa;
    EditText editRestoran, editLaundry, editExtraBed;
    DatePicker datePickerCheckIn;
    RadioButton rbLaki, rbPerempuan;
    Spinner spinJenisKamar, spinJumlahOrang;
    CheckBox cbRestoran, cbLaundry, cbExtraBed;
    Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        init();
        initSpinner();
        initCheckBox();
        cbAction();
        btnProsesAction();
        spinJenisKamarAction();
    }

    private void init() {
        editId = findViewById(R.id.edit_id);
        editLamaMenginap = findViewById(R.id.edit_lama_menginap);
        editHargaSewa = findViewById(R.id.edit_harga_sewa);
        editHargaSewa.setEnabled(false);
        editRestoran = findViewById(R.id.edit_restorant);
        editLaundry = findViewById(R.id.edit_laundry);
        editExtraBed = findViewById(R.id.edit_extra_bed);

        datePickerCheckIn = findViewById(R.id.date_picker_check_in);

        rbLaki = findViewById(R.id.rb_laki);
        rbLaki.setChecked(true);
        rbPerempuan = findViewById(R.id.rb_perempuan);

        spinJenisKamar = findViewById(R.id.spin_jenis_kamar);
        spinJumlahOrang = findViewById(R.id.spin_jumlah_orang);

        cbRestoran = findViewById(R.id.cb_restorant);
        cbLaundry = findViewById(R.id.cb_laundry);
        cbExtraBed = findViewById(R.id.cb_extra_bed);

        btnProses = findViewById(R.id.btn_proses);
    }

    private void initSpinner() {
        String[] jenisKamar = {"Superior", "Executive", "Standard", "Deluxe", "President"};
        ArrayAdapter<String> arrayAdapterJenisKamar = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, jenisKamar);
        arrayAdapterJenisKamar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinJenisKamar.setAdapter(arrayAdapterJenisKamar);

        String[] jumlahOrang = {"1 Orang Dewasa", "2 Orang Dewasa", "1 Orang Dewasa + 1 Anak", "2 Orang Dewasa + 2 Anak"};
        ArrayAdapter<String> arrayAdapterJumlahOrang = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, jumlahOrang);
        arrayAdapterJumlahOrang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinJumlahOrang.setAdapter(arrayAdapterJumlahOrang);
    }

    private void initCheckBox() {
        editRestoran.setEnabled(false);
        editLaundry.setEnabled(false);
        editExtraBed.setEnabled(false);
    }

    private void cbAction() {
        cbRestoran.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editRestoran.setEnabled(true);
                } else {
                    editRestoran.setEnabled(false);
                }
            }
        });

        cbLaundry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editLaundry.setEnabled(true);
                } else {
                    editLaundry.setEnabled(false);
                }
            }
        });

        cbExtraBed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editExtraBed.setEnabled(true);
                } else {
                    editExtraBed.setEnabled(false);
                }
            }
        });
    }

    private void btnProsesAction() {
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PemesananHotel pemesananHotel = new PemesananHotel();

                pemesananHotel.setId(editId.getText().toString());
                pemesananHotel.setTanggalCheckIn(getTanggalCheckIn());
                pemesananHotel.setJenisKamar(spinJenisKamar.getSelectedItem().toString());
                pemesananHotel.setLamaMenginap(editLamaMenginap.getText().toString() + " Hari");
                pemesananHotel.setHargaSewa("Rp. " + editHargaSewa.getText().toString());
                pemesananHotel.setJenisKelamin(getJenisKelamin());
                pemesananHotel.setJumlahOrang(spinJumlahOrang.getSelectedItem().toString());
                int tambahan = getTambahan();
                int total = getTotal(getTambahan());
                double pajak = total * 0.05;
                double totalBayar = total - pajak;
                pemesananHotel.setTambahan("Rp. " + tambahan);
                pemesananHotel.setTotal("Rp. " + total);
                pemesananHotel.setPajak("Rp. " + pajak);
                pemesananHotel.setTotalBayar("Rp. " + totalBayar);

                Intent intent = new Intent(TransaksiActivity.this, DetailTransaksi.class);
                intent.putExtra("PemesananHotel", pemesananHotel);
                startActivity(intent);
            }

            private int getTotal(int tambahan) {
                int[] listHargaOrang = {40000, 80000, 60000, 100000};
                int lama = Integer.parseInt(editLamaMenginap.getText().toString());
                int hargaKamar = Integer.parseInt(editHargaSewa.getText().toString());
                int hargaOrang = listHargaOrang[spinJumlahOrang.getSelectedItemPosition()];

                return (hargaKamar + hargaOrang + tambahan) * lama;
            }

            private int getTambahan() {
                int tambahan = 0;
                if (cbRestoran.isChecked()) {
                    tambahan += Integer.parseInt(editRestoran.getText().toString());
                }
                if (cbLaundry.isChecked()) {
                    tambahan += Integer.parseInt(editLaundry.getText().toString());
                }
                if (cbExtraBed.isChecked()) {
                    tambahan += Integer.parseInt(editExtraBed.getText().toString());
                }
                return tambahan;
            }

            private String getJenisKelamin() {
                String jekel = "";
                if (rbLaki.isSelected()) {
                    jekel = rbLaki.getText().toString();
                }
                if (rbPerempuan.isSelected()) {
                    jekel = rbPerempuan.getText().toString();
                }
                return jekel;
            }

            private String getTanggalCheckIn() {
                String tanggal = String.valueOf(datePickerCheckIn.getDayOfMonth());
                String[] listBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
                String bulan = listBulan[datePickerCheckIn.getMonth()];
                String tahun = String.valueOf(datePickerCheckIn.getYear());

                return tanggal + " - " + bulan + " - " + tahun;
            }
        });
    }

    private void spinJenisKamarAction() {
        spinJenisKamar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int[] listHargaKamar = {700000, 600000, 500000, 650000, 800000};
                editHargaSewa.setText(String.valueOf(listHargaKamar[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
