package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

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

public class create_account extends AppCompatActivity {
    TextView tvlogin;
    EditText etname,etmobile,etpswd,etage;
    Button btncreate_account;
    Dbhelper dbhelper;
    String name,mobile_no,password,age,amount="0";
    static int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        tvlogin=(TextView)findViewById(R.id.tvlogin);
        etname=(EditText)findViewById(R.id.etname);
        etmobile=(EditText)findViewById(R.id.etmobile);
        etpswd=(EditText)findViewById(R.id.etpswd);
        etage=(EditText)findViewById(R.id.etage);
        btncreate_account=(Button)findViewById(R.id.btncreate_account);
        dbhelper=new Dbhelper(this);



        btncreate_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();//add user in db
            }
        });
        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to login activity
                Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
            }
        });
    }
    private void registerUser() {
        //get all the values and store in variables
        name = etname.getText().toString().trim();
        mobile_no = etmobile.getText().toString().trim();
        password = etpswd.getText().toString().trim();
        age = etage.getText().toString().trim();

        //validation either edit text is empty or not
        if (name.isEmpty()) {
            etname.setError("name field is mandatory!");
            etname.requestFocus();
            return;
        }

        if (mobile_no.isEmpty()) {
            etmobile.setError("mobile Number field cannot be empty!");
            etmobile.requestFocus();
            return;
        }
        if (age.isEmpty()) {
            etage.setError("age field cannot be empty!");
            etage.requestFocus();
            return;
        }
        if (Integer.parseInt(age) <= 18) {
            etage.setError("age should be greater than 18!");
            etage.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etpswd.setError("password field cannot be empty!");
            etpswd.requestFocus();
            return;
        }
        //check mobile no. is exists or not
        if (dbhelper.checkMobileNo( mobile_no)) {
            Toast.makeText(this, "Mobile number already exists!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(flag==0)
            {
                flag=1;
                dbhelper.admin_pool(String.valueOf("500000"));
            }

            //Registration, add money and admin pool table created in db with the relevant fields
            if (dbhelper.register(name, mobile_no, age, password)) {
                if (dbhelper.add_money(mobile_no, amount)) {

                        reset();
                        CustomDialogClass customDialogClass = new CustomDialogClass(create_account.this);
                        customDialogClass.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        customDialogClass.show();
                    }

            } else {
                Toast.makeText(this, "Registration could not completed!", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public  void reset()
    {
        //Reset all the fields
        etmobile.getText().clear();
        etpswd.getText().clear();
        etage.getText().clear();
        etname.getText().clear();
    }
}