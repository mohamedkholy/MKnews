package com.momo.posts;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.momo.posts.databinding.ItemArticleCoverLayoutBinding;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LocalNewsAdapter extends RecyclerView.Adapter<LocalNewsAdapter.holder> {
    List<arical> l;
    onArticleclick onArticleclick;

    public LocalNewsAdapter(List<arical> l,onArticleclick onArticleclick) {
        this.l = l;
       this.onArticleclick=onArticleclick;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemArticleCoverLayoutBinding binding=    ItemArticleCoverLayoutBinding.bind(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_article_cover_layout,null,false));
        holder d=new holder(binding);
        return d;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        if(l.get(position).urlToImage==null)
            holder.binding.image.setImageURI(null);
        else
        Picasso.get().load(l.get(position).urlToImage.toString()).into( holder.binding.image);


        holder.binding.title.setText(l.get(position).getSource().name);
        String s=l.get(position).title;
        String[] ss=s.split("-");
        holder.binding.name.setText(ss[0]);
        String str=l.get(position).publishedAt;
        String[] sss=str.split("T");
        holder.binding.date.setText(sss[0]);
    }

    @Override
    public int getItemCount() {
        return l.size();
    }

    public  class holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ItemArticleCoverLayoutBinding binding;
        public holder(@NonNull ItemArticleCoverLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           onArticleclick.onclick(view,getAdapterPosition());
        }
    }
    public interface onArticleclick{

        void onclick(View view,int position);

    }

}
