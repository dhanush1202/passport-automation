package com.example.passportautomation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button applicant;
Button ppad;
Button ream;
Button pol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applicant=findViewById(R.id.applicant);
        ppad=findViewById(R.id.ppad);
        ream=findViewById(R.id.ream);
        pol=findViewById(R.id.pol);

        applicant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,applicant.class);
                startActivity(i);
            }
        });
    }
}