package com.momo.posts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.momo.posts.databinding.ActivitySettingsBinding;

public class settings extends AppCompatActivity {
  ActivitySettingsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySettingsBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        SharedPreferences sp=getSharedPreferences("coun",MODE_PRIVATE);
        binding.currCoun.setText(sp.getString("n_coun","US"));

        binding.country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(settings.this,country.class);
                startActivity(intent);
            }
        });

        binding.language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(settings.this,language.class);
                startActivity(intent);
            }
        });

    }
}