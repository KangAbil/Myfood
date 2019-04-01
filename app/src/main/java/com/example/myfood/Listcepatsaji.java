package com.example.myfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Listcepatsaji extends AppCompatActivity {
    protected ListView maaing;
    protected ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String,String>> mylist;
    String[] Pil;
    String[] Ltn;
    String[] Gbr;
    Button owalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcepatsaji);

        owalah = findViewById(R.id.owalah);
        owalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(Listcepatsaji.this,AksesBayar.class);
                startActivity(pindah);
            }
        });

        maaing = findViewById(R.id.maaing);

        Pil = new String[] {"Burger", "Hot Dog", "French Fries", "Popcorn", "Taco" };

        Ltn = new String[] {"Rp. xxxx","xxxxx", "zzzzzz", "yyyyy", "wwwwww"};

        Gbr = new String[] {Integer.toString(R.drawable.burger),
                Integer.toString(R.drawable.hotdog),
                Integer.toString(R.drawable.kentanggoreng),
                Integer.toString(R.drawable.popcorn), Integer.toString(R.drawable.taco) };

        maaing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Listcepatsaji.this, "Kamu memilih : " + Pil[position],Toast.LENGTH_LONG).show();
            }
        });

        mylist = new ArrayList<HashMap<String,String>>();

        for (int i = 0; i <Pil.length;i++){
            map = new HashMap<String, String>();
            map.put("list", Pil[i]);
            map.put("latin", Ltn[i]);
            map.put("gbr", Gbr[i]);
            mylist.add(map);
        }

        Adapter = new SimpleAdapter(this, mylist, R.layout.camilan,
                new String[] {"list", "latin", "gbr"}, new int[] {R.id.tetew, R.id.kunaon, R.id.wadaw});
        maaing.setAdapter(Adapter);
    }
}