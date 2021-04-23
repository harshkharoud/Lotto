package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText etmobile,etpswd;
    TextView tvcreate_account;
    Button btnlogin;
    String mobile_no,password;
    Dbhelper dbhelper;
    /*Session*/
    SessionManagement session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvcreate_account=(TextView)findViewById(R.id.tvcreate_account);
        etmobile=(EditText)findViewById(R.id.etmobile);
        etpswd=(EditText)findViewById(R.id.etpswd);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        dbhelper=new Dbhelper(this);
        session=new SessionManagement(getApplicationContext());
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        tvcreate_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),create_account.class);
                startActivity(intent);
            }
        });
    }
    private void loginUser() {

        mobile_no = etmobile.getText().toString().trim();
        password = etpswd.getText().toString().trim();
        //validation on edit text
        if (mobile_no.isEmpty()) {
            etmobile.setError("mobile Number field cannot be empty!");
            etmobile.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etpswd.setError("password field cannot be empty!");
            etpswd.requestFocus();
            return;
        }
        //check either user is registered or not
        if (dbhelper.checkUser( mobile_no, password)) {
            session.createLoginSession(etmobile.getText().toString());
            reset();
           Intent intent=new Intent(getApplication(),home.class);
           startActivity(intent);
        }
        else {
            Toast.makeText(this, "We're not able to recognize your account. Please use right login credentials!", Toast.LENGTH_SHORT).show();
        }

    }
        public  void reset()
        {
            //clear all the fields
            etmobile.getText().clear();
            etpswd.getText().clear();
        }

}