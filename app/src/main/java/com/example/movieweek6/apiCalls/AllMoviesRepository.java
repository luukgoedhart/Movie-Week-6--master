package com.example.movieweek6.apiCalls;

import com.example.movieweek6.AllMovies;

import retrofit2.Call;

class AllMoviesRepository {
    private AllMoviesApiService allMoviesApiService = AllMoviesApi.create();

    Call<AllMovies> getMostPopularMovies2018(int year) {
        return allMoviesApiService.getMostPopularMovies(year);
    }
}
