package com.example.android.themoviesapp.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.android.themoviesapp.R;
import com.example.android.themoviesapp.data.Movie;
import com.example.android.themoviesapp.view.DetailActivity;
import com.example.android.themoviesapp.view.MainActivity;
import com.squareup.picasso.Picasso;

import static android.R.string.no;
import static com.example.android.themoviesapp.view.MainActivity.MOVIE_KEY;

/**
 * Created by Professor on 7/25/2017.
 */

public class MovieViewModel extends BaseObservable {

    private Movie mMovie;
    private Context mContext;
    private static final String TAG = MovieViewModel.class.getSimpleName();

    public MovieViewModel(Movie movie, Context context) {
        this.mMovie = movie;
        this.mContext = context;
    }

    public String getImageUrl() {
        return "http://image.tmdb.org/t/p/w185/" + mMovie.getPoster();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Log.d(TAG, "loadImage: " + imageUrl);
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
    @Bindable
    public String getTitle() {
        return mMovie.getTitle();
    }
    @Bindable
    public String getDate() {
        return mMovie.getDate();
    }
    @Bindable
    public String getAverage() {
        return mMovie.getAverage();
    }
    @Bindable
    public String getOverview() {
        return mMovie.getOverview();
    }

    public View.OnClickListener onImageClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(MOVIE_KEY, mMovie);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        };
    }
}
