package com.example.lotto;

import android.content.Context;
import android.content.Intent;

public class common_functions {
    public  void openIndex(Context context)
    {
        /*Redirect to login activity*/
        Intent intent=new Intent(context, login.class);
        context.startActivity(intent);
    }
}
