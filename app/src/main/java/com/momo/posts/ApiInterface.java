package com.momo.posts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {



    @GET("v2/top-headlines?apiKey=d9fa5782b1694b0ea467ce6e7e150c7d")
    public Call<articalsparent> getArticalsLocalnews(@Query("page") int page,@Query("country") String s);

    @GET("v2/top-headlines?category=business&apiKey=d9fa5782b1694b0ea467ce6e7e150c7d")
    public Call<articalsparent> getArticalsbusiness(@Query("page") int page,@Query("country") String s);

    @GET("v2/top-headlines?category=sports&apiKey=d9fa5782b1694b0ea467ce6e7e150c7d")
    public Call<articalsparent> getArticalssport(@Query("page") int page,@Query("country") String s);



    @GET("v2/everything?apiKey=d9fa5782b1694b0ea467ce6e7e150c7d")
    public Call<articalsparent> getArticalsSearch(@Query("q") String g);

}
