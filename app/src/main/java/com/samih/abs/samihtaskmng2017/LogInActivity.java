package com.samih.abs.samihtaskmng2017;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    private EditText etEmail,etPassword;
    private Button btnSignIn,btnSignUp;
    //1.
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //2.
        auth=FirebaseAuth.getInstance();
        //if signed in...
        if(auth.getCurrentUser()!=null)
        {
            Intent i=new Intent(getBaseContext(),MainActivity.class);
            startActivity(i);
            finish();
        }

        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword= (EditText) findViewById(R.id.etPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp= (Button) findViewById(R.id.btnSignUp);

        eventHandler();

    }

    private void eventHandler()
    {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),SignUpActivity.class);
                startActivity(i);
            }
        });
    }


    private void dataHandler()
    {
        //TODO sign in by  firebase
        String stEmail=etEmail.getText().toString();
        String stPassword=etPassword.getText().toString();
        boolean isok=true;

        if(stEmail.indexOf('@')<1)
        {
            isok=false;
            etEmail.setError("Wrong email");
        }
        if (isok)
        {
            signIn(stEmail,stPassword);
        }

    }

    private void signIn(String stEmail, String stPassword)
    {
        final ProgressDialog progressDialog=ProgressDialog.show(this,"Wait","Signing in",true,true);
        progressDialog.show();
        //3.
        auth.signInWithEmailAndPassword(stEmail,stPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful())
                {
                    //4.
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(LogInActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
