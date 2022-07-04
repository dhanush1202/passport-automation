package com.example.passportautomation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class police extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<ArrayList<String>> list;
DatabaseReference databaseReference;
myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);
        recyclerView=findViewById(R.id.recyclerView);
        databaseReference= FirebaseDatabase.getInstance().getReference("vendor");
        list=new ArrayList<ArrayList<String>>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myadapter=new myadapter(this,list);
        recyclerView.setAdapter(myadapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> l1 = new ArrayList<>();
                for (DataSnapshot sp:snapshot.getChildren()){
                    if (( sp.child("police").getValue(String.class)).equals("pending")){
                        String name=sp.child("name").getValue(String.class);
                        String email=sp.child("email").getValue(String.class);
                        String pan=sp.child("pan1").getValue(String.class);
                        l1.add(name);
                        l1.add(email);
                        l1.add(pan);

                    }
                }
                list.add(l1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}