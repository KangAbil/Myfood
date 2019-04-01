package com.example.myfood;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int waktu_loading=2000;
    //2000=2 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah loading langsung pindah login activity
                Intent login=new Intent(MainActivity.this, Login.class);
                startActivity(login);
                finish();
            }
        },waktu_loading);

    }
}
