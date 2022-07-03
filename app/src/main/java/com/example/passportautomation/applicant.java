package com.example.passportautomation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class applicant extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Button login;
EditText id;
EditText pass;
TextView sign;
Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant);
        login=findViewById(R.id.login);
        id=findViewById(R.id.id);
        pass=findViewById(R.id.pass);
        sign=findViewById(R.id.signin);
        spinner=findViewById(R.id.spinner);
ArrayAdapter<CharSequence> ad=ArrayAdapter.createFromResource(this,R.array.person, android.R.layout.simple_spinner_item);
ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(ad);
spinner.setOnItemSelectedListener(this);
login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String idno=id.getText().toString();
            System.out.println(idno);
            String passw=pass.getText().toString();
            System.out.println(passw);
            Toast.makeText(applicant.this, "sucessfully logged in ", Toast.LENGTH_SHORT).show();

        }
    });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice=adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, choice, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}