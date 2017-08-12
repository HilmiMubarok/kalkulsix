package com.example.kalkulsix.kalkulatorantisix;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnplus, btnmin, btnkali, btnbagi;
    EditText txtangkaone, txtangkatwo;
    TextView txthasil;
    ImageView imggambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignUIElements();
        assignUIEvents();
    }

    private void assignUIElements() {
        btnplus = (Button) findViewById(R.id.btnplus);
        btnmin = (Button) findViewById(R.id.btnmin);
        btnkali = (Button) findViewById(R.id.btnkali);
        btnbagi = (Button) findViewById(R.id.btnbagi);
        txtangkaone = (EditText) findViewById(R.id.txtangkaone);
        txtangkatwo = (EditText) findViewById(R.id.txtangkatwo);
        txthasil = (TextView) findViewById(R.id.txthasil);
        imggambar = (ImageView) findViewById(R.id.imggambar);
    }


    private void assignUIEvents() {
        btnplus.setOnClickListener(this);
        btnmin.setOnClickListener(this);
        btnkali.setOnClickListener(this);
        btnbagi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int angka1 = Integer.parseInt(txtangkaone.getText().toString());
        int angka2 = Integer.parseInt(txtangkatwo.getText().toString());
        int hasil = 0;

        switch (view.getId()){
            case R.id.btnplus:
                hasil = angka1 + angka2;
                Toast.makeText(this, "tambah", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnmin:
                hasil = angka1 - angka2;
                Toast.makeText(this, "kurang", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnkali:
                hasil = angka1 * angka2;
                Toast.makeText(this, "kali", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnbagi:
                hasil = angka1 / angka2;
                Toast.makeText(this, "bagi", Toast.LENGTH_SHORT).show();
                break;
        }

        if (hasil == 6){
            txthasil.setText(getResources().getText(R.string.text_enam));
            txthasil.setTextColor(getResources().getColor(R.color.textsalah));
            imggambar.setImageResource(R.drawable.gilang);
        } else {
            txthasil.setText(String.valueOf(hasil));
            txthasil.setTextColor(getResources().getColor(R.color.textnormal));
            imggambar.setImageResource(0);
        }
    }
}
