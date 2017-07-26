package com.example.android.themoviesapp;

import android.app.LauncherActivity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.themoviesapp.data.Movie;
import com.example.android.themoviesapp.databinding.ListItemBinding;
import com.example.android.themoviesapp.viewmodel.MovieViewModel;

import java.util.List;

/**
 * Created by Professor on 7/25/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.BindingHolder> {

    private List<Movie> mMovies;
    private Context mContext;

    public MovieAdapter(Context context, List<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }
    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item, parent, false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ListItemBinding binding = holder.binding;
        binding.setMovievm(new MovieViewModel(mMovies.get(position), mContext));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ListItemBinding binding;

        public BindingHolder(ListItemBinding binding) {
            super(binding.listItemLayout);
            this.binding = binding;
        }
    }
}
