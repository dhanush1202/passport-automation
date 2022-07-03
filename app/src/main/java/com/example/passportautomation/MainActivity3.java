package com.example.passportautomation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {
TextView textview;
TextView appval;
TextView nm;
TextView em;
TextView ppa;
TextView rad;
TextView pol;

Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textview=findViewById(R.id.profile);
        appval=findViewById(R.id.appval);
        nm=findViewById(R.id.textView4);
        em=findViewById(R.id.textView7);
        ppa=findViewById(R.id.textView9);
        rad=findViewById(R.id.textView11);
        pol=findViewById(R.id.textView13);

        DatabaseReference fb=FirebaseDatabase.getInstance().getReference("vendor");
//        Query cu=fb.orderByChild("email").equalTo(MainActivity.idno);
        fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String na=snapshot.getValue().toString();
                System.out.println(MainActivity.idno);

                for(DataSnapshot sp:snapshot.getChildren()){
                    if((MainActivity.idno).equals(sp.child("email").getValue(String.class))){
                        System.out.println(sp.child("email").getValue(String.class));
                        em.setText(sp.child("email").getValue(String.class));
                        appval.setText(sp.child("application no").getValue(String.class));
                        ppa.setText(sp.child("pp admin").getValue(String.class));
                        rad.setText(sp.child("reg admin").getValue(String.class));
                        pol.setText(sp.child("police").getValue(String.class));
                        nm.setText(sp.child("name").getValue(String.class));

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Intent intent=new Intent();
        textview.setText(intent.getStringExtra(MainActivity.key));
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity3.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}