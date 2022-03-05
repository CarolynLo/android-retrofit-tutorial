package edu.uci.swe264p.retrofit;

import java.util.ArrayList;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface
MovieApiService {
    // https://api.themoviedb.org/3/movie/603?api_key=YOUR_API_KEY&language=en-US
    @GET("movie/{id}")
    Call<Movie> getMovie(@Path("id") int id, @Query("api_key") String apiKey);

    // https://api.themoviedb.org/3/movie/top_rated?api_key=YOUR_API_KEY
    @GET("movie/top_rated")
    Call<TopRatedResponse> getTopMovie(@Query("api_key") String apiKey);
}
