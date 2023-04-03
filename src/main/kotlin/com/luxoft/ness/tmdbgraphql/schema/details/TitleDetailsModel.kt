package com.luxoft.ness.tmdbgraphql.schema.details

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.server.extensions.getValueFromDataLoader
import com.luxoft.ness.tmdbgraphql.dataloaders.MovieImagesDataLoader
import com.luxoft.ness.tmdbgraphql.schema.Context
import com.luxoft.ness.tmdbgraphql.schema.images.MovieImages
import com.luxoft.ness.tmdbgraphql.tmdb.model.TitleDetails
import graphql.schema.DataFetchingEnvironment
import java.util.concurrent.CompletableFuture

data class TitleDetailsModel(
    @GraphQLDescription("Error message, null if no error")
    var error: String? = null,
    @GraphQLDescription("Whether the item is an adult item or not")
    var adult: Boolean? = null,
    @GraphQLDescription("Backdrop poster URL")
    var backdropPath: String? = null,
    @GraphQLDescription("Collection name, null if no collection")
    var belongsToCollection: TitleDetails.Collection? = null,
    @GraphQLDescription("Budget")
    var budget: Int? = null,
    @GraphQLDescription("List of genres of the title")
    var genres: ArrayList<TitleDetails.Genres> = arrayListOf(),
    @GraphQLDescription("Homepage URL")
    var homepage: String? = null,
    @GraphQLDescription("Original title language")
    var originalLanguage: String? = null,
    @GraphQLDescription("Original title")
    var originalTitle: String? = null,
    @GraphQLDescription("Title overview")
    var overview: String? = null,
    @GraphQLDescription("Title popularity")
    var popularity: Double? = null,
    @GraphQLDescription("Poster URL")
    var posterPath: String? = null,
    @GraphQLDescription("List of production companies")
    var productionCompanies: ArrayList<TitleDetails.ProductionCompanies> = arrayListOf(),
    @GraphQLDescription("List of production countries")
    var productionCountries: ArrayList<TitleDetails.ProductionCountries> = arrayListOf(),
    @GraphQLDescription("Release date")
    var releaseDate: String? = null,
    @GraphQLDescription("Revenue")
    var revenue: String? = null,
    @GraphQLDescription("List of spoken languages")
    var spokenLanguages: ArrayList<TitleDetails.SpokenLanguages> = arrayListOf(),
    @GraphQLDescription("Title")
    var title: String? = null,
    @GraphQLDescription("Title vote average")
    var voteAverage: Double? = null,
    @GraphQLDescription("Title vote count")
    var voteCount: Int? = null,
    @GraphQLIgnore
    var context: Context,
    @GraphQLIgnore
    val id: Int,
) {
    @GraphQLDescription("Title images")
    @GraphQLName("titleImages")
    fun movieImages(dataFetchingEnvironment: DataFetchingEnvironment): CompletableFuture<MovieImages> {
        return dataFetchingEnvironment.getValueFromDataLoader(
            MovieImagesDataLoader.name,
            MovieImagesDataLoader.Inputs(movieId = id, token = context.token)
        )
    }
}

/**
 * Creates a [TitleDetailsModel] from a [TitleDetails] object, most of the fields are exactly the same,
 * for [TitleDetailsModel] we just need to provide [Context] and error, if any
 */
fun TitleDetails.toTitleDetailsModel(context: Context, error: String?, id: Int): TitleDetailsModel {
    return TitleDetailsModel(
        error = error,
        adult = adult,
        backdropPath = backdropPath,
        belongsToCollection = belongsToCollection,
        budget = budget,
        genres = genres,
        homepage = homepage,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        productionCompanies = productionCompanies,
        productionCountries = productionCountries,
        releaseDate = releaseDate,
        revenue = revenue.toString(),
        spokenLanguages = spokenLanguages,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount,
        context = context,
        id = id
    )
}