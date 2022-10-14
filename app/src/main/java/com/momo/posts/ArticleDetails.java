package com.momo.posts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.momo.posts.databinding.ActivityArticleDetailsBinding;
import com.squareup.picasso.Picasso;

public class ArticleDetails extends AppCompatActivity {
ActivityArticleDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityArticleDetailsBinding.inflate(getLayoutInflater());
        View v=binding.getRoot();
        setContentView(v);

      arical a= (arical) getIntent().getSerializableExtra("post");


      binding.author.setText(a.author);

      if(a.description!=null){
        String s=a.description;
        String[] ss=s.split("\\[");
        binding.content.setText(ss[0]);
       }

        binding.date.setText(a.publishedAt);


        binding.title.setText(a.title);

        if(a.urlToImage!=null)
        Picasso.get().load(a.urlToImage.toString()).into(binding.imageView);


        binding.continu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Intent.ACTION_VIEW, Uri.parse(a.url.toString()));
                startActivity(k);

            }
        });
    }
}