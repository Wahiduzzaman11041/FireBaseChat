package com.example.wahid.firebasechat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    Button singin,login;
    EditText email,password;
    public ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        singin = findViewById(R.id.singinID);
        login = findViewById(R.id.loginID);
        email =findViewById(R.id.inputEmail);
        password= findViewById(R.id.inputPassword);

        progressDialog = new ProgressDialog(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String Memail = email.getText().toString();
                    String Mpassword = password.getText().toString();


                    if (!TextUtils.isEmpty(Memail)||!TextUtils.isEmpty(Mpassword))
                    {
                        progressDialog.setTitle("Processing");
                        progressDialog.setMessage("Try to Login");
                        progressDialog.show();
                        singinMathod(Memail,Mpassword);

                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Input E-mail or password",Toast.LENGTH_SHORT).show();
                    }
            }
        });

        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivaty =new Intent(MainActivity.this,Ragiser_Activaty.class);
                startActivity(loginActivaty);
            }
        });


    }

    private void singinMathod(String email1, String password1) {

        mAuth.signInWithEmailAndPassword(email1, password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    progressDialog.dismiss();
                    Intent loginActivaty =new Intent(MainActivity.this,Chatting.class);
                    startActivity(loginActivaty);
                }
                else
                {
                    progressDialog.cancel();
                    Toast.makeText(MainActivity.this,"Log in faild",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
