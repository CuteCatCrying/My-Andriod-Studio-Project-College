package com.zukron.project_hw_hotel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    public Button btnProses;
    public CheckBox cbBed, cbTowel;
    public EditText inputHargaKamar, inputLamaMenginap;
    public RadioButton rbExecutive, rbDeluxe, rbStandard, rbEconomic;
    public Spinner spinPembayaran, spinJumlahCustomer;
    public TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* List harga
         *  Executive = 250.000 / hari
         *  Deluxe = 200.000 / hari
         *  Standard = 150.000 / hari
         *  Economic = 100.000 / hari
         *
         *  Bed = 200.000
         *  Towel = 100.000
         * */

        addButton();
        addCheckBox();
        addEditText();
        addRadioButton();
        addSpinnerPembayaran();
        addSpinnerJumlahCustomer();
        addTextView();
    }

    private void addTextView() {
        txtOutput = (TextView) findViewById(R.id.txt_output);
    }

    private void addEditText() {
        inputHargaKamar = (EditText) findViewById(R.id.edit_harga_kamar);
        inputHargaKamar.setEnabled(false); // Read only EditText
        inputLamaMenginap = (EditText) findViewById(R.id.edit_lama_menginap);
    }

    private void addButton() {
        btnProses = (Button) findViewById(R.id.btn_proses);
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total, totalPajak, totalBayar;
                double pajak;
                double diskon = 0.0;
                int fasilitas = 0;
                String result;

                // parsing HargaKamar to int
                int hargaKamar = Integer.parseInt(
                        inputHargaKamar.getText().toString().substring(4, 7) + inputHargaKamar.getText().toString().substring(8, 11));
                int hari = Integer.parseInt(inputLamaMenginap.getText().toString());

                // array hargaCustomer, nilai didapatkan dari position pada spinJumlahCustomer
                int[] hargaCustomer = {50000, 100000, 150000, 70000, 120000, 140000};

                // get checkbox
                if (cbBed.isChecked()) {
                    fasilitas += 200000;
                }
                if (cbTowel.isChecked()) {
                    fasilitas += 100000;
                }

                total = (double) (hargaCustomer[spinJumlahCustomer.getSelectedItemPosition()] + hargaKamar + fasilitas) * hari;
                pajak = total * 0.05;
                totalPajak = total + pajak;

                if (hari > 10) {
                    diskon = totalPajak * 0.1;
                }

                totalBayar = totalPajak - diskon;

                result = "Total " + getString(R.string.tab) + " : Rp. " + total;
                result += "\nPajak " + getString(R.string.tab) + " : Rp. " + pajak;
                result += "\nTotal Pajak " + getString(R.string.tab) + " : Rp. " + totalPajak;
                result += "\nDiskon \t\t\t\t\t\t: Rp. " + diskon;
                result += "\nTotal Bayar \t\t\t\t\t\t: Rp. " + totalBayar;
                result += "\nPemabayaran via \t: " + spinPembayaran.getSelectedItem().toString();

                txtOutput.setText(result);
            }
        });
    }

    private void addCheckBox() {
        cbBed = (CheckBox) findViewById(R.id.cb_bed);
        cbTowel = (CheckBox) findViewById(R.id.cb_towel);
    }

    // Avoid causes multiple checked radio button
    private void addRadioButton() {
        rbExecutive = (RadioButton) findViewById(R.id.rb_executive);
        rbExecutive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbDeluxe.setChecked(false);
                    rbStandard.setChecked(false);
                    rbEconomic.setChecked(false);
                    inputHargaKamar.setText("Rp. 250.000");
                }
            }
        });

        rbDeluxe = (RadioButton) findViewById(R.id.rb_deluxe);
        rbDeluxe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbExecutive.setChecked(false);
                    rbStandard.setChecked(false);
                    rbEconomic.setChecked(false);
                    inputHargaKamar.setText("Rp. 200.000");
                }
            }
        });

        rbStandard = (RadioButton) findViewById(R.id.rb_standard);
        rbStandard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbExecutive.setChecked(false);
                    rbDeluxe.setChecked(false);
                    rbEconomic.setChecked(false);
                    inputHargaKamar.setText("Rp. 150.000");
                }
            }
        });

        rbEconomic = (RadioButton) findViewById(R.id.rb_economic);
        rbEconomic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbExecutive.setChecked(false);
                    rbDeluxe.setChecked(false);
                    rbStandard.setChecked(false);
                    inputHargaKamar.setText("Rp. 100.000");
                }
            }
        });
    }

    private void addSpinnerPembayaran() {
        spinPembayaran = (Spinner) findViewById(R.id.spin_pembayaran);
        List<String> listItemPembayaran = new ArrayList<String>();
        listItemPembayaran.add("Tunai");
        listItemPembayaran.add("Credit Card");
        listItemPembayaran.add("ATM");

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listItemPembayaran);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinPembayaran.setAdapter(aa);
    }

    private void addSpinnerJumlahCustomer() {
        spinJumlahCustomer = (Spinner) findViewById(R.id.spin_jumlah_customer);
        List<String> listItemJumlahCustomer = new ArrayList<String>();
        listItemJumlahCustomer.add("1 Orang Dewasa"); // Rp. 50.000
        listItemJumlahCustomer.add("2 Orang Dewasa"); // Rp. 100.000
        listItemJumlahCustomer.add("3 Orang Dewasa"); // Rp. 150.000
        listItemJumlahCustomer.add("1 Orang Dewasa + 1 Anak Kecil"); // Rp. 70.000
        listItemJumlahCustomer.add("2 Orang Dewasa + 1 Anak Kecil"); // Rp. 120.000
        listItemJumlahCustomer.add("2 Orang Dewasa + 2 Anak Kecil"); // Rp. 140.000

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listItemJumlahCustomer);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinJumlahCustomer.setAdapter(aa);
    }
}
