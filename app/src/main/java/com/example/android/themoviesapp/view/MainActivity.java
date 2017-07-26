package com.example.android.themoviesapp.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.themoviesapp.MovieAdapter;
import com.example.android.themoviesapp.R;
import com.example.android.themoviesapp.data.ApiClient;
import com.example.android.themoviesapp.data.ApiInterface;
import com.example.android.themoviesapp.data.Movie;
import com.example.android.themoviesapp.data.MoviesResponse;
import com.example.android.themoviesapp.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String IMDB_KEY = "89ee093e8d6112a3a785c20be1c11818";
    public static final String MOVIE_KEY = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MoviesResponse> call = apiInterface.getPopularMovies(IMDB_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> moviesList = response.body().getResults();
                Log.d(TAG, moviesList.toString());
                MovieAdapter adapter = new MovieAdapter(getApplication(), moviesList);
                binding.recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
