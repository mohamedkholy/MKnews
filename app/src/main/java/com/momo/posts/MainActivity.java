package com.momo.posts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
SharedPreferences sp;
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("coun",MODE_PRIVATE);



        String s=sp.getString("lang","en");
        h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                setLocale(MainActivity.this,s);
                Intent intent=new Intent(MainActivity.this,home.class);
                startActivity(intent);
                finish();
            }
        },3000);





    }


   public static void setLocale(Context context, String lang) {
       Locale locale = new Locale(lang);
        locale.setDefault(locale);
       Resources res = context.getResources();
       Configuration conf = res.getConfiguration();
       conf.locale = locale;
       conf.setLayoutDirection(locale);
       res.updateConfiguration(conf,  res.getDisplayMetrics());




   }
}