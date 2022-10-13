package com.momo.posts;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.momo.posts.databinding.FragmentEconomyBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class economy extends Fragment {
FragmentEconomyBinding binding;
    LocalNewsAdapter.onArticleclick onArticleclick;
    List<arical> l;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public economy() {

    }


    public static economy newInstance(String param1, String param2) {
        economy fragment = new economy();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_economy, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding=FragmentEconomyBinding.bind(view);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface=retrofit.create(ApiInterface.class);

        Call<articalsparent> call=apiInterface.getArticalsbusiness();



        call.enqueue(new Callback<articalsparent>() {
            @Override
            public void onResponse(Call<articalsparent> call, Response<articalsparent> response) {

                l=response.body().articles;
                LocalNewsAdapter adapter=new LocalNewsAdapter(l,onArticleclick);
                binding.economyRecv.setAdapter(adapter);
                binding.lin.setVisibility(View.GONE);


            }

            @Override
            public void onFailure(Call<articalsparent> call, Throwable t) {
                binding.lin.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Connection Faild", Toast.LENGTH_SHORT).show();
                binding.economyRecv.setVisibility(View.GONE);


            }
        });


        onArticleclick=new LocalNewsAdapter.onArticleclick() {
            @Override
            public void onclick(View view, int position) {



                Intent intent=new Intent(getContext(),ArticleDetails.class);
                intent.putExtra("post",l.get(position));

                startActivity(intent);
            }
        };



        binding.refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("https://newsapi.org/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiInterface apiInterface=retrofit.create(ApiInterface.class);

                Call<articalsparent> call=apiInterface.getArticalsbusiness();
                call.enqueue(new Callback<articalsparent>() {
                    @Override
                    public void onResponse(Call<articalsparent> call, Response<articalsparent> response) {
                        binding.economyRecv.setVisibility(View.VISIBLE);
                        l=response.body().articles;
                        LocalNewsAdapter adapter=new LocalNewsAdapter(l,onArticleclick);
                        binding.economyRecv.setAdapter(adapter);
                        binding.refresh.setRefreshing(false);

                    }

                    @Override
                    public void onFailure(Call<articalsparent> call, Throwable t) {
                        Log.d("gggggggggggg", "onResponsefaliure: "+    t.getLocalizedMessage());
                        binding.refresh.setRefreshing(false);
                    }
                });

            }
        });


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}