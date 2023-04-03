package com.luxoft.ness.tmdbgraphql

import com.luxoft.ness.tmdbgraphql.tmdb.TMDBApi
import com.luxoft.ness.tmdbgraphql.tmdb.interceptor.ErrorHandlingInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@SpringBootApplication
class TheMovieDbGraphQlApiWrapperApplication {

    @Bean
    fun loggingInterceptor(environment: Environment) = HttpLoggingInterceptor().apply {
        level = if (environment.activeProfiles.contains("prod")) {
            HttpLoggingInterceptor.Level.BASIC
        } else {
            HttpLoggingInterceptor.Level.BODY
        }
    }

    @Bean
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .addInterceptor(ErrorHandlingInterceptor())
        .addInterceptor(loggingInterceptor)
        .build()

    @Bean
    fun createRegistryClient(@Autowired client: OkHttpClient) =
        Retrofit.Builder()
            .client(client)
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TMDBApi::class.java)
}

fun main(args: Array<String>) {
    runApplication<TheMovieDbGraphQlApiWrapperApplication>(*args)
}
