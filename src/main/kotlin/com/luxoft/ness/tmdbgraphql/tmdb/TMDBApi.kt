package com.luxoft.ness.tmdbgraphql.tmdb

import com.luxoft.ness.tmdbgraphql.schema.credits.Credits
import com.luxoft.ness.tmdbgraphql.tmdb.model.TitleDetails
import com.luxoft.ness.tmdbgraphql.schema.images.MovieImages
import com.luxoft.ness.tmdbgraphql.schema.trending.ItemType
import com.luxoft.ness.tmdbgraphql.schema.trending.TrendingData
import com.luxoft.ness.tmdbgraphql.schema.trending.TrendingTimePeriod
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBApi {
    @GET("/3/trending/{type}/{period}")
    suspend fun trending(
        @Path("type") itemType: ItemType? = null,
        @Path("period") timePeriod: TrendingTimePeriod? = null,
        @Query("page") page: Int? = null,
        @Query("api_key") apiKey: String,
    ): Response<TrendingData>

    @GET("/3/movie/{movieId}")
    suspend fun details(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String,
    ): Response<TitleDetails>

    @GET("/3/movie/{movieId}/credit")
    suspend fun credits(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String,
    ): Response<Credits>

    @GET("/3/movie/{movieId}/images")
    suspend fun images(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String,
    ): Response<MovieImages>
}