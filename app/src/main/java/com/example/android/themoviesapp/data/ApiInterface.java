package com.example.android.themoviesapp.data;

import com.example.android.themoviesapp.data.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Professor on 7/24/2017.
 */

public interface ApiInterface {
    @GET("popular")
    Call<MoviesResponse> getPopularMovies(@Query("api_key") String key);
}
