package com.momo.posts;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;


import com.momo.posts.databinding.ActivityLanguageBinding;



public class language extends AppCompatActivity {
ActivityLanguageBinding binding;
SharedPreferences sp;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivity.setLocale(this,getSharedPreferences("coun",MODE_PRIVATE).getString("lang","en"));
        super.onCreate(savedInstanceState);
        binding=ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sp=getSharedPreferences("coun",MODE_PRIVATE);
        editor=sp.edit();
        binding.arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("lang","ar");
                editor.commit();
                triggerRebirth(language.this);

            }
        });
        binding.english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("lang","en");
                editor.commit();
                triggerRebirth(language.this);
            }
        });


    }
    public static void triggerRebirth(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent.getComponent();
        Intent mainIntent = Intent.makeRestartActivityTask(componentName);
        context.startActivity(mainIntent);
        Runtime.getRuntime().exit(0);
    }




}