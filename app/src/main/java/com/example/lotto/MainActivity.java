package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button btnLogin,btnaccount,btnplay,btninfo,btnabout,btnfaq;
    SessionManagement session;
    String mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=(Button)findViewById(R.id.btnlogin);
        btnaccount=(Button)findViewById(R.id.btnaccount);
        btnplay=(Button)findViewById(R.id.btnplay);
        btninfo=(Button)findViewById(R.id.btninfo);
        btnabout=(Button)findViewById(R.id.btnabout);
        btnfaq=(Button)findViewById(R.id.btnfaq);
        btnaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to create account activity
                Intent intent=new Intent(getApplicationContext(),create_account.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to  login activity
                Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
            }
        });
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to  play activity
                Intent i=new Intent(getApplication(),play.class);
                startActivity(i);
            }
        });
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to  info activity
                Intent i=new Intent(getApplication(),info.class);
                startActivity(i);
            }
        });
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to  about activity
                Intent i=new Intent(getApplication(),about.class);
                startActivity(i);
            }
        });
        btnfaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to  faq activity
                Intent i=new Intent(getApplication(),faq.class);
                startActivity(i);
            }
        });
    }

}