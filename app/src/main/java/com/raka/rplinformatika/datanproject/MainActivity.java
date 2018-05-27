package com.raka.rplinformatika.datanproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CardView tambah, Cari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tambah = findViewById(R.id.cardviewadd);
        Cari = findViewById(R.id.cardviewsearch);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TambahActivity.class);
                startActivity(i);
            }
        });

        Cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ib = new Intent(MainActivity.this, LihatActivity.class);
                startActivity(ib);
            }
        });
    }
}
