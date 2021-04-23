package com.example.lotto;
//All the relevant packages are imported
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class home extends AppCompatActivity {
    Button btnaddmoney,btnticket,btnlogout,btnplay,btninfo,btnfaq;
    SessionManagement session;
    String mobile;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       session.logoutUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        session = new SessionManagement(getApplication());
        btnaddmoney=(Button)findViewById(R.id.btnaddmoney);
        btnticket=(Button)findViewById(R.id.btnticket);
        btnlogout=(Button)findViewById(R.id.btnlogout);
        btnplay=(Button)findViewById(R.id.btnplay);
        btninfo=(Button)findViewById(R.id.btninfo);
        btnfaq=(Button)findViewById(R.id.btnfaq);
        btnaddmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to Add money activity
                Intent intent=new Intent(getApplicationContext(),add_money.class);
                startActivity(intent);
            }
        });
        btnticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to buy ticket activity
                Intent intent=new Intent(getApplicationContext(),buy_ticket.class);
                startActivity(intent);
            }
        });
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to buy logout activity
                session=new SessionManagement(getApplication());
                session.logoutUser();

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