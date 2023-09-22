package com.momo.posts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.momo.posts.databinding.ActivityHomeBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class home extends AppCompatActivity {
    private ActivityHomeBinding binding;
    LocalNewsAdapter.onArticleclick onArticleClick;
    List<article> l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivity.setLocale(this, getSharedPreferences("coun", MODE_PRIVATE).getString("lang", "en"));
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        pagerdabter pagerdabter = new pagerdabter(getSupportFragmentManager(), getBaseContext());
        binding.homePager.setAdapter(pagerdabter);
        binding.homePager.setOffscreenPageLimit(3);
        binding.homeTab.setupWithViewPager(binding.homePager);
        onArticleClick = (view1, position) -> {

            Intent intent = new Intent(getBaseContext(), ArticleDetails.class);
            intent.putExtra("post", l.get(position));

            startActivity(intent);

        };

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setQueryHint(getBaseContext().getString(R.string.Search));

        searchView.setOnSearchClickListener(view -> binding.imageView.setVisibility(View.GONE));


        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {

                binding.imageView.setVisibility(View.VISIBLE);
                binding.recv.setVisibility(View.GONE);
                binding.progressCircular.setVisibility(View.GONE);
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    binding.progressCircular.setVisibility(View.GONE);
                    binding.recv.setVisibility(View.GONE);

                } else {
                    binding.progressCircular.setVisibility(View.VISIBLE);
                    binding.recv.setVisibility(View.VISIBLE);
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://newsapi.org/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    ApiInterface apiInterface = retrofit.create(ApiInterface.class);

                    Call<articalsparent> call = apiInterface.getArticalsSearch(newText);
                    call.enqueue(new Callback<articalsparent>() {
                        @Override
                        public void onResponse(@NonNull Call<articalsparent> call, @NonNull Response<articalsparent> response) {
                            binding.progressCircular.setVisibility(View.GONE);
                            assert response.body() != null;
                            l = response.body().articles;

                            LocalNewsAdapter adapter = new LocalNewsAdapter(l, onArticleClick);
                            binding.recv.setAdapter(adapter);
                            adapter.notifyDataSetChanged();


                        }

                        @Override
                        public void onFailure(Call<articalsparent> call, Throwable t) {
                            Log.d("gggggggggggg", "onResponsefaliure: " + t.getLocalizedMessage());
                            binding.progressCircular.setVisibility(View.GONE);
                        }
                    });


                }

                return false;
            }
        });


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.options) {
            Intent intent = new Intent(home.this, settings.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


}