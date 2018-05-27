package com.raka.rplinformatika.datanproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LihatActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference table_user;

    private ListView listView;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        data = new Data();

        listView = findViewById(R.id.ListView);
        database = FirebaseDatabase.getInstance();
        table_user = database.getReference("Dataku");

        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.data_info, R.id.textSet, list);

        table_user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    data =  ds.getValue(Data.class);
                    list.add(data.getKeterangan().toString().trim()+" "+data.getNama().toString().trim()+"   "+data.getPemasukan().toString().trim());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
