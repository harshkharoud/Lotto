package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class buy_ticket extends AppCompatActivity implements View.OnClickListener
{
    Button btnbuy;
    SessionManagement session;
    String mobile;
    int random_number,pre_amount,pool_amount;
    boolean result;
    long admin_pool=500000;
    Dbhelper dbhelper;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30;
    Button  b31,b32,b33,b34,b35,b36,b37,b38,b39,b40,b41,b42,b43,b44,b45,b46,b47,b48,b49,b50;
    int b1flag=0;
    ArrayList<Integer> aList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();
        mobile = user.get(session.KEY_MOBILE);

        btnbuy=(Button)findViewById(R.id.btnbuy);
        dbhelper=new Dbhelper(this);
       findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btn10).setOnClickListener(this);
        findViewById(R.id.btn11).setOnClickListener(this);
        findViewById(R.id.btn12).setOnClickListener(this);
        findViewById(R.id.btn13).setOnClickListener(this);
        findViewById(R.id.btn14).setOnClickListener(this);
        findViewById(R.id.btn15).setOnClickListener(this);
        findViewById(R.id.btn16).setOnClickListener(this);
        findViewById(R.id.btn17).setOnClickListener(this);
        findViewById(R.id.btn18).setOnClickListener(this);
        findViewById(R.id.btn19).setOnClickListener(this);
        findViewById(R.id.btn20).setOnClickListener(this);
        findViewById(R.id.btn21).setOnClickListener(this);
        findViewById(R.id.btn22).setOnClickListener(this);
        findViewById(R.id.btn23).setOnClickListener(this);
        findViewById(R.id.btn24).setOnClickListener(this);
        findViewById(R.id.btn25).setOnClickListener(this);
        findViewById(R.id.btn26).setOnClickListener(this);
        findViewById(R.id.btn27).setOnClickListener(this);
        findViewById(R.id.btn28).setOnClickListener(this);
        findViewById(R.id.btn29).setOnClickListener(this);
        findViewById(R.id.btn30).setOnClickListener(this);
        findViewById(R.id.btn31).setOnClickListener(this);
        findViewById(R.id.btn32).setOnClickListener(this);
        findViewById(R.id.btn33).setOnClickListener(this);
        findViewById(R.id.btn34).setOnClickListener(this);
        findViewById(R.id.btn35).setOnClickListener(this);
        findViewById(R.id.btn36).setOnClickListener(this);
        findViewById(R.id.btn37).setOnClickListener(this);
        findViewById(R.id.btn38).setOnClickListener(this);
        findViewById(R.id.btn39).setOnClickListener(this);
        findViewById(R.id.btn40).setOnClickListener(this);
        findViewById(R.id.btn41).setOnClickListener(this);
        findViewById(R.id.btn42).setOnClickListener(this);
        findViewById(R.id.btn43).setOnClickListener(this);
        findViewById(R.id.btn44).setOnClickListener(this);
        findViewById(R.id.btn45).setOnClickListener(this);
        findViewById(R.id.btn46).setOnClickListener(this);
        findViewById(R.id.btn47).setOnClickListener(this);
        findViewById(R.id.btn48).setOnClickListener(this);
        findViewById(R.id.btn49).setOnClickListener(this);
        findViewById(R.id.btn50).setOnClickListener(this);

        btnbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(aList.size()<6)
        {
        switch (v.getId()) {
            case R.id.btn1:
                b1 = (Button) findViewById(R.id.btn1);
                b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b1.setEnabled(false);
                aList.add(1);
                break;
            case R.id.btn2:
                b2 = (Button) findViewById(R.id.btn2);
                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b2.setEnabled(false);
                aList.add(2);
                break;
            case R.id.btn3:
                b3 = (Button) findViewById(R.id.btn3);
                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b3.setEnabled(false);
                aList.add(3);
                break;
            case R.id.btn4:
                b4 = (Button) findViewById(R.id.btn4);
                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b4.setEnabled(false);
                aList.add(4);
                break;
            case R.id.btn5:
                b5 = (Button) findViewById(R.id.btn5);
                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b5.setEnabled(false);
                aList.add(5);
                break;
            case R.id.btn6:
                b6 = (Button) findViewById(R.id.btn6);
                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b6.setEnabled(false);
                aList.add(6);
                break;
            case R.id.btn7:
                b7 = (Button) findViewById(R.id.btn7);
                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b7.setEnabled(false);
                aList.add(7);
                break;
            case R.id.btn8:
                b8 = (Button) findViewById(R.id.btn8);
                b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b8.setEnabled(false);
                aList.add(8);
                break;
            case R.id.btn9:
                b9 = (Button) findViewById(R.id.btn9);
                b9.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b9.setEnabled(false);
                aList.add(9);
                break;
            case R.id.btn10:
                b10 = (Button) findViewById(R.id.btn10);
                b10.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b10.setEnabled(false);
                aList.add(10);
                break;
            case R.id.btn11:
                b11 = (Button) findViewById(R.id.btn11);
                b11.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b11.setEnabled(false);
                aList.add(11);
                break;
            case R.id.btn12:
                b12 = (Button) findViewById(R.id.btn12);
                b12.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b12.setEnabled(false);
                aList.add(12);
                break;
            case R.id.btn13:
                b13 = (Button) findViewById(R.id.btn13);
                b13.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b13.setEnabled(false);
                aList.add(13);
                break;
            case R.id.btn14:
                b14 = (Button) findViewById(R.id.btn14);
                b14.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b14.setEnabled(false);
                aList.add(14);
                break;
            case R.id.btn15:
                b15 = (Button) findViewById(R.id.btn15);
                b15.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b15.setEnabled(false);
                aList.add(15);
                break;
            case R.id.btn16:
                b16 = (Button) findViewById(R.id.btn16);
                b16.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b16.setEnabled(false);
                aList.add(16);
                break;
            case R.id.btn17:
                b17 = (Button) findViewById(R.id.btn17);
                b17.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b17.setEnabled(false);
                aList.add(17);
                break;
            case R.id.btn18:
                b18 = (Button) findViewById(R.id.btn18);
                b18.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b18.setEnabled(false);
                aList.add(18);
                break;
            case R.id.btn19:
                b19 = (Button) findViewById(R.id.btn19);
                b19.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b19.setEnabled(false);
                aList.add(19);
                break;
            case R.id.btn20:
                b20 = (Button) findViewById(R.id.btn20);
                b20.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b20.setEnabled(false);
                aList.add(20);
                break;
            case R.id.btn21:
                b21 = (Button) findViewById(R.id.btn21);
                b21.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b21.setEnabled(false);
                aList.add(21);
                break;
            case R.id.btn22:
                b22 = (Button) findViewById(R.id.btn22);
                b22.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b22.setEnabled(false);
                aList.add(22);
                break;
            case R.id.btn23:
                b23 = (Button) findViewById(R.id.btn23);
                b23.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b23.setEnabled(false);
                aList.add(23);
                break;
            case R.id.btn24:
                b24 = (Button) findViewById(R.id.btn24);
                b24.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b24.setEnabled(false);
                aList.add(24);
                break;
            case R.id.btn25:
                b25 = (Button) findViewById(R.id.btn25);
                b25.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b25.setEnabled(false);
                aList.add(25);
                break;
            case R.id.btn26:
                b26 = (Button) findViewById(R.id.btn26);
                b26.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b26.setEnabled(false);
                aList.add(26);
                break;
            case R.id.btn27:
                b27 = (Button) findViewById(R.id.btn27);
                b27.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b27.setEnabled(false);
                aList.add(27);
                break;
            case R.id.btn28:
                b28 = (Button) findViewById(R.id.btn28);
                b28.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b28.setEnabled(false);
                aList.add(28);
                break;
            case R.id.btn29:
                b29 = (Button) findViewById(R.id.btn29);
                b29.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b29.setEnabled(false);
                aList.add(29);
                break;
            case R.id.btn30:
                b30 = (Button) findViewById(R.id.btn30);
                b30.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b30.setEnabled(false);
                aList.add(30);
                break;
            case R.id.btn31:
                b31 = (Button) findViewById(R.id.btn31);
                b31.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b31.setEnabled(false);
                aList.add(31);
                break;
            case R.id.btn32:
                b32 = (Button) findViewById(R.id.btn32);
                b32.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b32.setEnabled(false);
                aList.add(32);
                break;
            case R.id.btn33:
                b33 = (Button) findViewById(R.id.btn33);
                b33.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b33.setEnabled(false);
                aList.add(33);
                break;
            case R.id.btn34:
                b34 = (Button) findViewById(R.id.btn34);
                b34.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b34.setEnabled(false);
                aList.add(34);
                break;
            case R.id.btn35:
                b35 = (Button) findViewById(R.id.btn35);
                b35.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b35.setEnabled(false);
                aList.add(35);
                break;
            case R.id.btn36:
                b36 = (Button) findViewById(R.id.btn36);
                b36.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b36.setEnabled(false);
                aList.add(36);
                break;
            case R.id.btn37:
                b37 = (Button) findViewById(R.id.btn37);
                b37.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b37.setEnabled(false);
                aList.add(37);
                break;
            case R.id.btn38:
                b38 = (Button) findViewById(R.id.btn38);
                b38.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b38.setEnabled(false);
                aList.add(38);
                break;
            case R.id.btn39:
                b39 = (Button) findViewById(R.id.btn39);
                b39.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b39.setEnabled(false);
                aList.add(39);
                break;
            case R.id.btn40:
                b40 = (Button) findViewById(R.id.btn40);
                b40.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b40.setEnabled(false);
                aList.add(40);
                break;
            case R.id.btn41:
                b41 = (Button) findViewById(R.id.btn41);
                b41.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b41.setEnabled(false);
                aList.add(41);
                break;
            case R.id.btn42:
                b42 = (Button) findViewById(R.id.btn42);
                b42.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b42.setEnabled(false);
                aList.add(42);
                break;
            case R.id.btn43:
                b43 = (Button) findViewById(R.id.btn43);
                b43.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b43.setEnabled(false);
                aList.add(43);
                break;
            case R.id.btn44:
                b44 = (Button) findViewById(R.id.btn44);
                b44.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b44.setEnabled(false);
                aList.add(44);
                break;
            case R.id.btn45:
                b45 = (Button) findViewById(R.id.btn45);
                b45.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b45.setEnabled(false);
                aList.add(45);
                break;
            case R.id.btn46:
                b46 = (Button) findViewById(R.id.btn46);
                b46.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b46.setEnabled(false);
                aList.add(46);
                break;
            case R.id.btn47:
                b47 = (Button) findViewById(R.id.btn47);
                b47.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b47.setEnabled(false);
                aList.add(47);
                break;
            case R.id.btn48:
                b48 = (Button) findViewById(R.id.btn48);
                b48.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b48.setEnabled(false);
                aList.add(48);
                break;
            case R.id.btn49:
                b49 = (Button) findViewById(R.id.btn49);
                b49.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b49.setEnabled(false);
                aList.add(49);
                break;
            case R.id.btn50:
                b50 = (Button) findViewById(R.id.btn50);
                b50.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_fill_button));
                b50.setEnabled(false);
                aList.add(50);
                break;
        }
        }
        else {
             Toast.makeText(getApplication(),"you should select six number !",Toast.LENGTH_SHORT).show();
            }

    }
    public  void validate()
    {
        getAmount();
        if(aList.size()==6) {
            if (pre_amount >= 5) {
                random_number = getRandomNumber(1, 50);
                result = aList.contains(random_number);

                if (result) {
                    deduct_from_pool();
                    add_money();
                    Intent intent = new Intent(this, result.class);
                    Bundle extras = new Bundle();
                    extras.putString("message", "Congratulations! you won. Wining Number is " + random_number);
                    intent.putExtras(extras);
                    startActivity(intent);
                } else {
                    deduct_money();
                    add_money_in_pool();
                    Intent intent = new Intent(getApplication(), result.class);
                    intent.putExtra("message", "Sorry, Better luck next time. Winnning Number is " + random_number);
                    intent.putExtra("randomnumber", random_number);
                    startActivity(intent);
                }
                reset();
            }
            else {
                Toast.makeText(getApplication(),"you do not have sufficient amount!",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(getApplication(),"you should select six number !",Toast.LENGTH_SHORT).show();
        }
    }
    private int getRandomNumber(int min,int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }

    public void reset()
    {
        aList.clear();
        random_number=0;
    }

    public  void deduct_money()
    {
        int amount=5;
        getAmount();
        pre_amount-=amount;
        dbhelper.update_money(mobile,String.valueOf(pre_amount));
    }
    public  void add_money()
    {
        int amount=100000;
        getAmount();
        pre_amount+=amount;
        dbhelper.update_money(mobile,String.valueOf(pre_amount));
    }
    public  void getAmount()
    {
        Cursor r=dbhelper.show(mobile);
        StringBuilder sb=new StringBuilder();
        while (r.moveToNext())
        {
            pre_amount=Integer.parseInt(r.getString(0).toString());
        }
    }
    public  void get_pool_amount()
    {
        Cursor r=dbhelper.show_pool();
        while (r.moveToNext())
        {
            pool_amount=Integer.parseInt(r.getString(0).toString());
        }
    }
    public  void add_money_in_pool()
    {
        int amount=5;
        get_pool_amount();
        pool_amount+=amount;
        dbhelper.update_pool(String.valueOf(pool_amount));
    }
    public  void deduct_from_pool()
    {
        int amount=100000;
        get_pool_amount();
        pool_amount-=amount;
        dbhelper.update_pool(String.valueOf(pool_amount));
    }

}