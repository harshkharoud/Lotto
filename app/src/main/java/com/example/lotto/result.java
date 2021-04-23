package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class result extends AppCompatActivity {

    String message,random_number;
    Button btnmoney,btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();
        message= extras.getString("message");
        Toast.makeText(getApplication(),message,Toast.LENGTH_LONG).show();
        btnmoney=(Button)findViewById(R.id.btnmoney);
        btnback=(Button)findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),home.class);
                startActivity(intent);
            }
        });
        btnmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),add_money.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Redirect to home activity when back key pressed
        startActivity(new Intent(this, home.class));
        finish();
    }
}