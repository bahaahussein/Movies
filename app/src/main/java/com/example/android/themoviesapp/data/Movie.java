package com.example.android.themoviesapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Professor on 7/24/2017.
 */

public class Movie implements Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String poster;

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        poster = in.readString();
        overview = in.readString();
        date = in.readString();
        average = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String date;

    @SerializedName("vote_average")
    private String average;

    public Movie(int id, String title, String poster, String overview, String date, String average) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.overview = overview;
        this.date = date;
        this.average = average;
    }


    public String getAverage() {
        return average;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getOverview() {
        return overview;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "id: " + id + ", title: " + title + ", poster: " + poster + ", overview: " +
                overview + ", date: " + date + ", average: " + average + "\n";
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(poster);
        dest.writeString(overview);
        dest.writeString(date);
        dest.writeString(average);
    }
}
