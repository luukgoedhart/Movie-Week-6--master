package com.example.movieweek6.apiCalls;

import com.example.movieweek6.AllMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AllMoviesApiService {
    @GET("/3/discover/movie?api_key=d53208ce7e22b88f51f9850034e0e416&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    Call<AllMovies> getMostPopularMovies(@Query("year") int year);
}