package com.example.android.themoviesapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Professor on 7/24/2017.
 */

public class MoviesResponse {
    @SerializedName("results")
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }
}