package com.example.android.themoviesapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.themoviesapp.R;
import com.example.android.themoviesapp.data.Movie;
import com.example.android.themoviesapp.databinding.ActivityDetailBinding;
import com.example.android.themoviesapp.view.MainActivity;
import com.example.android.themoviesapp.viewmodel.MovieViewModel;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        Movie movie = extras.getParcelable(MainActivity.MOVIE_KEY);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_detail);
        binding.setMovievm(new MovieViewModel(movie, this));
    }
}
