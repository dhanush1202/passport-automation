package com.example.passportautomation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity3 extends AppCompatActivity {
TextView textview;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textview=findViewById(R.id.profile);
        DatabaseReference fb=FirebaseDatabase.getInstance().getReference("vendor");

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