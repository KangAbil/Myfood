package com.example.myfood;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    ProgressBar progressBar1;
    FirebaseAuth firebaseAuth;
    TextView lupass1;
    EditText katasandi1,email1;
    TextView txt1;
    ImageView login1;
    Button masuk1;
    Button daftar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar1 = findViewById(R.id.progressBar1);
        firebaseAuth = firebaseAuth.getInstance();
        lupass1 =   findViewById(R.id.lupass1);
        katasandi1 = findViewById(R.id.katasandi1);
        email1 =  findViewById(R.id.email1);
        txt1 =  findViewById(R.id.txt1);
        login1 =  findViewById(R.id.login1);
        masuk1 =  findViewById(R.id.masuk1);
        masuk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar1.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(email1.getText().toString(), katasandi1.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar1.setVisibility(View.GONE);

                        if(task.isSuccessful()) {
                            Intent masuk1 = new Intent(Login.this,NavDraw.class);
                            startActivity(masuk1);
                        } else {
                            Toast.makeText(Login.this, "Kamu Belum Daftar/Login", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
        daftar1 = findViewById(R.id.daftar1);
        daftar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar = new Intent(Login.this,Daftar.class);
                startActivity(daftar);
            }
        });

    }
}
