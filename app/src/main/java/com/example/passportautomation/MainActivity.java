package com.example.passportautomation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button login;
    EditText id;
    EditText pass;
    TextView sign;
    Spinner spinner;
    String cha;
    FirebaseAuth au;
    private void regis(String id,String pwd, String cha){
    au.signInWithEmailAndPassword(id,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){
                Toast.makeText(MainActivity.this, "sucessfully logged in ", Toast.LENGTH_SHORT).show();
//                FirebaseDatabase.getInstance().getReference().child("vendor1").setValue("hello1");
            }
            else{
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        id=findViewById(R.id.id);
        pass=findViewById(R.id.pass);
        sign=findViewById(R.id.sit);
        spinner=findViewById(R.id.spinner);
        au=FirebaseAuth.getInstance();

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
                if (TextUtils.isEmpty(idno) || TextUtils.isEmpty(passw)){
                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
                else {
                     regis(idno,passw,cha);
                }
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        cha=adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, cha, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}