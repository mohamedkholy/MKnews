package com.momo.posts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {



    @GET("v2/top-headlines?apiKey=cfd9620a95f6413da3ad3641a0c94ce2")
    public Call<articalsparent> getArticalsLocalnews(@Query("page") int page,@Query("country") String s);

    @GET("v2/top-headlines?category=business&apiKey=cfd9620a95f6413da3ad3641a0c94ce2")
    public Call<articalsparent> getArticalsbusiness(@Query("page") int page,@Query("country") String s);

    @GET("v2/top-headlines?category=sports&apiKey=cfd9620a95f6413da3ad3641a0c94ce2")
    public Call<articalsparent> getArticalssport(@Query("page") int page,@Query("country") String s);



    @GET("v2/everything?apiKey=cfd9620a95f6413da3ad3641a0c94ce2")
    public Call<articalsparent> getArticalsSearch(@Query("q") String g);

}
