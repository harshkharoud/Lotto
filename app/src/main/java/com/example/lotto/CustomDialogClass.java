package com.example.lotto;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomDialogClass extends Dialog implements
        android.view.View.OnClickListener {

    public Context c;
    public Dialog d;
    public Button yes;
    common_functions functions=new common_functions();
    /*Custom dialog show after registration completed*/
    public CustomDialogClass(Context a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        yes = (Button) findViewById(R.id.btn_yes);
        yes.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //After click yes button redirect to login activity
            case R.id.btn_yes:
                login res=new login();
                functions.openIndex(getContext());
                break;
        }
        dismiss();
    }
}