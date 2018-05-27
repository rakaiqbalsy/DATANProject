package com.raka.rplinformatika.datanproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TambahActivity extends AppCompatActivity {

    private EditText id, keterangan, nama, pemasukan;
    private Button btnSimpan;

    private FirebaseDatabase database;
    private DatabaseReference table_user;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        id = findViewById(R.id.Idku);
        keterangan = findViewById(R.id.Keterangan);
        nama = findViewById(R.id.nama);
        pemasukan = findViewById(R.id.pemasukan);

        database = FirebaseDatabase.getInstance();
        table_user = database.getReference("Dataku");

        btnSimpan = findViewById(R.id.savebtn);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressDialog = new ProgressDialog(TambahActivity.this);
                mProgressDialog.setMessage("Memesan Pilihan ....");
                mProgressDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(id.getText().toString()).exists()) {
                            mProgressDialog.dismiss();
                            Toast.makeText(TambahActivity.this, "ID HARUS UNIQUE !!", Toast.LENGTH_LONG).show();

                            Intent i = new Intent(TambahActivity.this, LihatActivity.class);
                            startActivity(i);
                        }
                        else {
                                mProgressDialog.dismiss();
                                Data data = new Data(keterangan.getText().toString().trim(),
                                        nama.getText().toString().trim(),
                                        pemasukan.getText().toString().trim());

                            table_user.child(id.getText().toString()).setValue(data);
                            Toast.makeText(TambahActivity.this, "Berhasil Memesan", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(TambahActivity.this, LihatActivity.class);
                            startActivity(i);
                            finish();

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });


    }
}
