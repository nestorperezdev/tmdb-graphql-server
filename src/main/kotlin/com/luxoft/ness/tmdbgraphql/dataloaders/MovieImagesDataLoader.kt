package com.luxoft.ness.tmdbgraphql.dataloaders

import com.expediagroup.graphql.dataloader.KotlinDataLoader
import com.luxoft.ness.tmdbgraphql.schema.images.MovieImages
import com.luxoft.ness.tmdbgraphql.schema.images.toMovieImages
import com.luxoft.ness.tmdbgraphql.tmdb.TMDBApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import org.dataloader.DataLoader
import org.dataloader.DataLoaderFactory
import org.dataloader.DataLoaderOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MovieImagesDataLoader : KotlinDataLoader<MovieImagesDataLoader.Inputs, MovieImages> {

    @Autowired
    private lateinit var tmdbApi: TMDBApi

    override val dataLoaderName = name

    companion object {
        const val name = "MovieImagesDataLoader"
    }

    data class Inputs(val movieId: Int, val token: String)

    override fun getDataLoader(): DataLoader<Inputs, MovieImages> =
        DataLoaderFactory.newDataLoader({ inputs ->
            GlobalScope.future {
                inputs.map {
                    tmdbApi.images(movieId = it.movieId, apiKey = it.token).toMovieImages()
                }
            }
        }, DataLoaderOptions.newOptions().setCachingEnabled(true))
}