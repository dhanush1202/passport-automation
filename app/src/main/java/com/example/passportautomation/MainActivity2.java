package com.example.passportautomation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
EditText name;
EditText fname;
EditText dob;
EditText add;
EditText pno;
EditText email;
EditText pswd;
EditText pan;
EditText cpswd;
Button sig;
FirebaseAuth au;
public void reg(String id, String pswd){
    au.createUserWithEmailAndPassword(id,pswd).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){
                Toast.makeText(MainActivity2.this, "Sign in successful", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity2.this, "Failed!!", Toast.LENGTH_SHORT).show();
            }
        }
    });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=findViewById(R.id.Name);
        fname=findViewById(R.id.fname);
        dob=findViewById(R.id.dob);
        add=findViewById(R.id.address);
        pno=findViewById(R.id.pno);
        email=findViewById(R.id.email);
        pan = findViewById(R.id.pan);
        pswd= findViewById(R.id.pswd);
        cpswd=findViewById(R.id.cpaswd);
        sig=findViewById(R.id.sign);
        au=FirebaseAuth.getInstance();
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String na=name.getText().toString();
                String fn=fname.getText().toString();
                String db=dob.getText().toString();
                String ad=add.getText().toString();
                String po=pno.getText().toString();
                String em=email.getText().toString();
                String pan1=pan.getText().toString();
                String pwd=pswd.getText().toString();
                String cpwd=cpswd.getText().toString();
                if (TextUtils.isEmpty(na)||TextUtils.isEmpty(fn)||TextUtils.isEmpty(db)||TextUtils.isEmpty(ad)||TextUtils.isEmpty(cpwd)||TextUtils.isEmpty(po)||TextUtils.isEmpty(em)||TextUtils.isEmpty(pan1)||TextUtils.isEmpty(pwd)){
                    Toast.makeText(MainActivity2.this, "enter all details", Toast.LENGTH_SHORT).show();
                }
                else{
                    reg(em,pwd);
                    Toast.makeText(MainActivity2.this, "successfully signed in", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}