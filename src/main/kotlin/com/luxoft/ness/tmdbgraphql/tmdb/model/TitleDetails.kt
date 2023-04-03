package com.luxoft.ness.tmdbgraphql.tmdb.model

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.google.gson.annotations.SerializedName
import com.luxoft.ness.tmdbgraphql.schema.Context
import java.math.BigInteger

data class TitleDetails(
    @SerializedName("adult") var adult: Boolean? = null,
    @GraphQLDescription("Backdrop poster URL")
    @SerializedName("backdrop_path") var backdropPath: String? = null,
    @GraphQLDescription("Collection name, null if no collection")
    @SerializedName("belongs_to_collection") var belongsToCollection: Collection? = null,
    @GraphQLDescription("Budget")
    @SerializedName("budget") var budget: Int? = null,
    @GraphQLDescription("List of genres of the title")
    @SerializedName("genres") var genres: ArrayList<Genres> = arrayListOf(),
    @GraphQLDescription("Homepage URL")
    @SerializedName("homepage") var homepage: String? = null,
    @GraphQLDescription("Item ID")
    @SerializedName("id") var id: Int,
    @GraphQLIgnore
    @SerializedName("imdb_id") var imdbId: String? = null,
    @GraphQLDescription("Original title language")
    @SerializedName("original_language") var originalLanguage: String? = null,
    @GraphQLDescription("Original title")
    @SerializedName("original_title") var originalTitle: String? = null,
    @GraphQLDescription("Title overview")
    @SerializedName("overview") var overview: String? = null,
    @GraphQLDescription("Title popularity")
    @SerializedName("popularity") var popularity: Double? = null,
    @GraphQLDescription("Poster URL")
    @SerializedName("poster_path") var posterPath: String? = null,
    @GraphQLDescription("List of production companies")
    @SerializedName("production_companies") var productionCompanies: ArrayList<ProductionCompanies> = arrayListOf(),
    @GraphQLDescription("List of production countries")
    @SerializedName("production_countries") var productionCountries: ArrayList<ProductionCountries> = arrayListOf(),
    @GraphQLDescription("Release date")
    @SerializedName("release_date") var releaseDate: String? = null,
    @GraphQLDescription("Revenue")
    @SerializedName("revenue") var revenue: BigInteger? = null,
    @GraphQLIgnore
    @SerializedName("runtime") var runtime: Int? = null,
    @GraphQLDescription("List of spoken languages")
    @SerializedName("spoken_languages") var spokenLanguages: ArrayList<SpokenLanguages> = arrayListOf(),
    @GraphQLIgnore
    @SerializedName("status") var status: String? = null,
    @GraphQLIgnore
    @SerializedName("tagline") var tagline: String? = null,
    @GraphQLDescription("Title")
    @SerializedName("title") var title: String? = null,
    @GraphQLIgnore
    @SerializedName("video") var video: Boolean? = null,
    @GraphQLDescription("Title vote average")
    @SerializedName("vote_average") var voteAverage: Double? = null,
    @GraphQLDescription("Title vote count")
    @SerializedName("vote_count") var voteCount: Int? = null,
    @GraphQLIgnore
    var context: Context? = null
) {
    data class ProductionCompanies(
        @SerializedName("id") var id: Int? = null,
        @SerializedName("logo_path") var logoPath: String? = null,
        @SerializedName("name") var name: String? = null,
        @SerializedName("origin_country") var originCountry: String? = null
    )

    data class Genres(
        @SerializedName("id") var id: Int? = null,
        @SerializedName("name") var name: String? = null
    )

    data class ProductionCountries(
        @SerializedName("iso_3166_1") var iso31661: String? = null,
        @SerializedName("name") var name: String? = null
    )

    data class SpokenLanguages(
        @SerializedName("english_name") var englishName: String? = null,
        @SerializedName("iso_639_1") var iso6391: String? = null,
        @SerializedName("name") var name: String? = null
    )

    data class Collection(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("backdrop_path")
        val backdropPath: String?
    )
}

