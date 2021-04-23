package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class add_money extends AppCompatActivity {
    EditText etamount;
    TextView tvback,tvsetamount;
    Button btnadd;
    String mobile,amount;
    int pre_amount;
    SessionManagement session;
    Dbhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);
        /*Get the user mobile from session*/
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();
        mobile = user.get(session.KEY_MOBILE);
        /*Create object of Db helper*/
        dbhelper=new Dbhelper(this);
        etamount=(EditText)findViewById(R.id.etamount);
        btnadd=(Button)findViewById(R.id.btnadd);
        tvback=(TextView)findViewById(R.id.tvback);
        tvsetamount=(TextView)findViewById(R.id.tvsetamount);
        getAmount();
        tvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Redirect to home*/
                Intent intent=new Intent(getApplication(),home.class);
                startActivity(intent);
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoney();//function called and add money in db
            }
        });
    }
    private void addMoney() {
        amount = etamount.getText().toString().trim();
        /*Validation on amount edittext*/
        if (amount.isEmpty()) {
            etamount.setError("amount cannot be empty!");
            etamount.requestFocus();
            return;
        }
        /*getAmount function called for previous amount*/
        getAmount();
        /*Update the new Amount*/
        pre_amount+=Integer.parseInt(amount);
        if (dbhelper.update_money(mobile,String.valueOf(pre_amount))) {
            reset();
            getAmount();
            Toast.makeText(this, "Amount credit!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Amount could not credit!", Toast.LENGTH_SHORT).show();
        }

    }
    public  void getAmount()
    {
        /*Get The Previous amount of user*/
        Cursor r=dbhelper.show(mobile);
        StringBuilder sb=new StringBuilder();
        while (r.moveToNext())
        {
            pre_amount=Integer.parseInt(r.getString(0).toString());
            tvsetamount.setText(String.valueOf(pre_amount));
        }
    }
    public  void reset()
    {
        etamount.setText("");
    }
    @Override
    public void onBackPressed() {
        /*Redirect to Home Activity*/
        super.onBackPressed();
        startActivity(new Intent(this, home.class));
        finish();
    }
}