package com.momo.posts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.momo.posts.databinding.ActivityArticleDetailsBinding;
import com.squareup.picasso.Picasso;

public class ArticleDetails extends AppCompatActivity {
ActivityArticleDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivity.setLocale(this,getSharedPreferences("coun",MODE_PRIVATE).getString("lang","en"));
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
                if(a.url==null)
                    Toast.makeText(ArticleDetails.this, "Error 404", Toast.LENGTH_SHORT).show();
                else{
                Intent k=new Intent(ArticleDetails.this,webv.class );
                k.putExtra("url",a.url.toString());
                startActivity(k);}

            }
        });
    }


}