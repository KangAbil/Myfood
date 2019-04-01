package com.example.myfood;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Daftar extends AppCompatActivity {
    ProgressBar progressBar2;
    ImageView login2;
    TextView txt2;
    EditText email2,nama2,katasandi2,ulangkatasandi2;
    Button daftar2;
    TextView sudakun2,masuksin2;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        progressBar2 = findViewById(R.id.progressBar2);
        login2 = findViewById(R.id.login2);
        txt2 = findViewById(R.id.txt2);
        email2 = findViewById(R.id.email2);
        nama2 = findViewById(R.id.nama2);
        katasandi2 = findViewById(R.id.katasandi2);
        ulangkatasandi2 = findViewById(R.id.ulangkatasandi2);
        daftar2 = findViewById(R.id.daftar2);
        sudakun2 = findViewById(R.id.sudakun2);
        masuksin2 = findViewById(R.id.masuksin2);
        masuksin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masuksin2 = new Intent(Daftar.this,Login.class);
                startActivity(masuksin2);
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);
        daftar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar2.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(email2.getText().toString(), katasandi2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar2.setVisibility(View.GONE);
                        if(task.isSuccessful()) {
                            Toast.makeText(Daftar.this, "Daftar Berhasil", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(Daftar.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}