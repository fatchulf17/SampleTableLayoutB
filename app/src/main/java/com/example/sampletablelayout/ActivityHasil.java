package com.example.sampletablelayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityHasil extends AppCompatActivity {
    //Mendeklarasikan variabel dengan tipe data textview
    TextView txEmail, txPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityhasil);

        //menghubungkan variabel txmail dengan komponen textview pada layout
        txEmail = findViewById(R.id.tvEmail);

        //menghubungkan variabel txpassword dengan komponen textview pada layout
        txPassword = findViewById(R.id.tvpassword);

        //membuatobjek bundle dan mengambil data yang di kirimkan dari act sebelumnya
        Bundle bundle = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari act sebelunya dengan kunci a
        String email = bundle.getString("a");

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari act sebelunya dengan kunci b
        String pass = bundle.getString("b");

        //menampilkan value dari variabel email kedalam txEmail
        txEmail.setText(email);

        //menampilkan value dari variabel pass kedalam txPassword
        txPassword.setText(pass);
    }
}
