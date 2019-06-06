package com.example.movieweek6.movieInformation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieweek6.DownloadImageTask;
import com.example.movieweek6.MainActivity;
import com.example.movieweek6.Movie;
import com.example.movieweek6.R;

import java.util.Objects;

public class MovieInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_information);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView mBackdropImage = findViewById(R.id.backdropImage);
        ImageView mPosterImage = findViewById(R.id.posterImage);
        TextView mTitle = findViewById(R.id.title);
        TextView mReleaseDate = findViewById(R.id.releaseDate);
        TextView mRating = findViewById(R.id.rating);
        TextView mOverview = findViewById(R.id.overview);

        Movie movie = getIntent().getParcelableExtra(MainActivity.SHOW_MOVIE_DETAILS);

        new DownloadImageTask(mBackdropImage).execute(movie.getBackdropPath());
        new DownloadImageTask(mPosterImage).execute(movie.getPosterPath());

        mTitle.setText(movie.getTitle());
        mReleaseDate.setText("Release: " + movie.getReleaseDate());
        mRating.setText(movie.getVoteAverage().toString());
        mOverview.setText(movie.getOverview());
    }

    /**
     * Called when the back button is pressed
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
