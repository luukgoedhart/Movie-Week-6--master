package com.example.movieweek6.apiCalls;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.movieweek6.AllMovies;
import com.example.movieweek6.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {
    private AllMoviesRepository allMoviesRepository = new AllMoviesRepository();

    private MutableLiveData<List<Movie>> movie = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getError() {
        return error;
    }

    public MutableLiveData<List<Movie>> getAllMovies() {
        return movie;
    }

    public void getMostPopularMovies(int year) {
        allMoviesRepository
                .getMostPopularMovies2018(year)
                .enqueue(new Callback<AllMovies>() {
                    @Override
                    public void onResponse(@NonNull Call<AllMovies> call, @NonNull Response<AllMovies> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            movie.setValue(response.body().getResults());
                        } else {
                            error.setValue("Api Error: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<AllMovies> call, @NonNull Throwable t) {
                        error.setValue("Api Error: " + t.getMessage());
                    }
                });
    }
}