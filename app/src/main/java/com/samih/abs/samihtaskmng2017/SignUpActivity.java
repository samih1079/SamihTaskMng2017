package com.samih.abs.samihtaskmng2017;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.samih.abs.samihtaskmng2017.data.DBUtils;
import com.samih.abs.samihtaskmng2017.data.MyUser;

public class SignUpActivity extends AppCompatActivity {

    private EditText etEmail,etPassword,etRePassword,etPhone,etName;
    private Button btnSave;


    //1.
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        etRePassword=(EditText)findViewById(R.id.etRePassword);
        etPhone=(EditText)findViewById(R.id.etPhone);
        etName=(EditText)findViewById(R.id.etName);
        btnSave= (Button) findViewById(R.id.btnSave);


        //2.
        auth=FirebaseAuth.getInstance();


        eventHandler();

    }

    private void eventHandler()
    {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              dataHandler();
            }
        });
    }

    private void dataHandler()
    {
        final String stEmail=etEmail.getText().toString();
        String stPassword=etPassword.getText().toString();
        String stRepassword=etRePassword.getText().toString();
        final String stPhone=etPhone.getText().toString();
        final String stName=etName.getText().toString();

        boolean isOk=true;
        if(stEmail.length()<6 || stEmail.indexOf('@')<1)
        {
            etEmail.setError("Wrong Email");
            isOk=false;
        }
        if(stName.length()==0)
        {
            etName.setError("Required Field");
            isOk=false;
        }
        //Todo complete the rest check...

        if(isOk)
        {
            final ProgressDialog progressDialog=ProgressDialog.show(this,"Wait...","Signing up",true,true);
            progressDialog.show();
            //DBUtils.auth
            auth.createUserWithEmailAndPassword(stEmail,stPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {

                    if(task.isSuccessful())
                    {
                        //Todo add new user to MyUsers database
                        MyUser myUser=new MyUser();
                        myUser.setName(stName);
                        myUser.setuKey_email(stEmail);
                        myUser.setPhone(stPhone);

                        DBUtils.myUsersRef.child(myUser.getuKey_email()).setValue(myUser)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                progressDialog.dismiss();
                                if(task.isSuccessful())
                                {
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(SignUpActivity.this,
                                            task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this,task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        task.getException().printStackTrace();
                    }

                }
            });
        }
        else
        {

        }


    }
}
