package com.momo.posts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {



    @GET("v2/top-headlines?country=eg&apiKey=c82acb2e60864a5dadf8b307afcbf31f")
    public Call<articalsparent> getArticalsLocalnews();

    @GET("v2/top-headlines?country=eg&category=business&apiKey=c82acb2e60864a5dadf8b307afcbf31f")
    public Call<articalsparent> getArticalsbusiness();


}
