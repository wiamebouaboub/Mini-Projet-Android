package com.example.monprofil

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbAPI {
    @GET("search/movie")
    suspend fun getFilmsParMotCle(
        @Query("api_key") apikey: String,
        @Query("query") motcle: String
    ): MovieResult

    @GET("trending/movie/week")
    suspend fun getFilmsInitiaux(
        @Query("api_key") apikey: String,
    ): MovieResult

    @GET("trending/tv/week")
    suspend fun getSeriesInitiaux(
        @Query("api_key") apikey: String,
    ): SerieResult

    @GET("trending/person/week")
    suspend fun getActeurs(
        @Query("api_key") apikey: String,
    ): PeopleResult

    @GET("movie/{id}")
    suspend fun getFilm(
        @Path("id") id:String, @Query("api_key")apikey: String,@Query("append_to_response")appendToResponse: String
    ): MovieInfo

    @GET("tv/{id}")
    suspend fun getSerie(
        @Path("id") id:String, @Query("api_key")apikey: String,@Query("append_to_response")appendToResponse: String
    ): SerieInfo
}

