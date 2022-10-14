package com.momo.posts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.momo.posts.databinding.ActivityCountryBinding;

public class country extends AppCompatActivity {
ActivityCountryBinding binding;
SharedPreferences sp;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCountryBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        sp=getSharedPreferences("coun",MODE_PRIVATE);
        editor=sp.edit();
        Intent intent = new Intent(country.this, home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
        binding.egypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("coun","EG");
                editor.putString("n_coun",binding.egypt.getText().toString());
                editor.apply();

                startActivity(intent);
                finish();




            }
        });

        binding.us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("coun","US");
                editor.putString("n_coun",binding.us.getText().toString());
                editor.apply();
                startActivity(intent);
                finish();
            }
        });

        binding.Turkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("coun","TR");
                editor.putString("n_coun",binding.Turkey.getText().toString());
                editor.apply();
                startActivity(intent);
                finish();
            }
        });

        binding.France.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("coun","FR");
                editor.putString("n_coun",binding.France.getText().toString());
                editor.apply();
                startActivity(intent);
                finish();
            }
        });

        binding.UAE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("coun","AE");
                editor.putString("n_coun",binding.UAE.getText().toString());
                editor.apply();
                startActivity(intent);
                finish();
            }
        });

        binding.Ukraine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("coun","ua");
                editor.putString("n_coun",binding.Ukraine.getText().toString());
                editor.apply();
                startActivity(intent);
                finish();
            }
        });

        binding.uk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("coun","GB");
                editor.putString("n_coun",binding.uk.getText().toString());
                editor.apply();
                startActivity(intent);
                finish();
            }
        });





    }
}