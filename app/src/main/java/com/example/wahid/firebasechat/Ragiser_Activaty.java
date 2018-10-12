package com.example.wahid.firebasechat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Ragiser_Activaty extends AppCompatActivity  {

    private FirebaseAuth mAuth;
    ProgressDialog progressDialog ;

    EditText name,email,passwoerd;
    Button singin;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragiser__activaty);

        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.NameId);
        email = findViewById(R.id.EmailId);
        passwoerd = findViewById(R.id.PasswordId);
        singin = findViewById(R.id.SingINId);

        toolbar = findViewById(R.id.register_appBarId);
        progressDialog = new ProgressDialog(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String Mname = name.getText().toString();
                    String Memail = email.getText().toString();
                    String password1 = passwoerd.getText().toString();
                    if (!TextUtils.isEmpty(Mname)||!TextUtils.isEmpty(Memail)||!TextUtils.isEmpty(password1))
                    {
                        progressDialog.setMessage("Try to Sing up");
                        progressDialog.setTitle("Processing...");
                        progressDialog.show();
                        loginPanal(Memail , password1);
                    }
                    else
                    {
                        Toast.makeText(Ragiser_Activaty.this,"Input E-mail or password",Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }


    private void loginPanal(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email ,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    Intent chattingActivaty =new Intent(Ragiser_Activaty.this,Chatting.class);
                    startActivity(chattingActivaty);
                }
                else
                    {
                        progressDialog.cancel();
                        Toast.makeText(Ragiser_Activaty.this,"Log in Unsuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
