package com.example.passportautomation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class applicant extends AppCompatActivity {
Button login;
EditText id;
EditText pass;
TextView sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant);
        login=findViewById(R.id.login);
        id=findViewById(R.id.id);
        pass=findViewById(R.id.pass);
        sign=findViewById(R.id.signin);
    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String idno=id.getText().toString();
            String passw=pass.getText().toString();

        }
    });
    }

}