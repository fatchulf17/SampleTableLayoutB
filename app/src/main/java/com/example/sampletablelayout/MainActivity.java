package com.example.sampletablelayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk edit text
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menu untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId()==R.id.mnDaftar)
        {
            //method untuk memanggil act "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel btnLogin dengan komponen button pada layout
        btnLogin=findViewById(R.id.btSignIn);

        //menghubungkan variabel edemail dengan komponen button pada layout
        edemail=findViewById(R.id.edEmail);

        //menghubungkan variabel edpassword dengan komponen button pada layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //mengeset email yang benar
                String email = "admin@mail.com";

                //mengeset password yang benar
                String pass = "123";

                //mengecek apakah edit text email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {
                    //membuat variabel toasy dan menampilan pesan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan password wajib diisi!!!",
                            Toast.LENGTH_LONG);

                    //menampilkan toast
                    t.show();
                } else{

                    //mengecek apakah isi dari email dan password sudah sama dengan email dan
                    //password yang sudah diset
                    if (nama.equals(email) && password.equals(pass)) {
                        //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                        Toast t = Toast.makeText(getApplicationContext(),
                                "email anda: " + nama + "dan Password anda: " + password + "", Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();

                        //membuat object bundle
                        Bundle b = new Bundle();

                        //memasukkan value dari variabel nama dengan kunci "a"
                        //dan dimasukkan kedalam bundle

                        b.putString ("a", nama.trim());

                        //memasukkan value dari variabel password dengan kunci "b"
                        b.putString("b", password.trim());

                        //membuat object intent berpindah activity dari main activity ke activity hasil
                        Intent i = new Intent (getApplicationContext(),ActivityHasil.class);

                        //memasukkan bundle kedalam intent untuk dikirimkan ke Activity hasil
                        i.putExtras(b);
                        //berpindah ke ActivityHasil
                        startActivity(i);
                    } else {
                        //membuat variabel toast dan membuat toast dan menmpilkan pesan "Logib sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagagl", Toast.LENGTH_LONG);

                        //menampilkan toast
                        t.show();
                    }
                }
            }
        });


    }
}