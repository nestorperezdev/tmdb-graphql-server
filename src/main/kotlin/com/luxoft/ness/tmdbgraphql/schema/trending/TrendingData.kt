package com.luxoft.ness.tmdbgraphql.schema.trending

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.google.gson.annotations.SerializedName

data class TrendingData(
    @GraphQLDescription("Page number of the results")
    @SerializedName("page") var page: Int? = null,
    @GraphQLDescription("Results")
    @SerializedName("results") var results: ArrayList<Results> = arrayListOf(),
    @GraphQLDescription("Total number of pages")
    @SerializedName("total_pages") var totalPages: Int? = null,
    @GraphQLDescription("Total number of results")
    @SerializedName("total_results") var totalResults: Int? = null,
    @GraphQLDescription("Error message, null if no error")
    var error: String? = null
) {
    data class Results(
        @GraphQLDescription("Whether the item is an adult item or not")
        @SerializedName("adult") var adult: Boolean? = null,
        @GraphQLDescription("Backdrop poster URL")
        @SerializedName("backdrop_path") var backdropPath: String? = null,
        @GraphQLDescription("Item ID")
        @SerializedName("id") var id: Int? = null,
        @GraphQLDescription("Item name")
        @SerializedName("name") var name: String? = null,
        @GraphQLIgnore
        @SerializedName("original_language") var originalLanguage: String? = null,
        @GraphQLDescription("Original item name")
        @SerializedName("original_name") var originalName: String? = null,
        @GraphQLDescription("Overview")
        @SerializedName("overview") var overview: String? = null,
        @GraphQLDescription("Poster URL")
        @SerializedName("poster_path") var posterPath: String? = null,
        @GraphQLDescription("Item type")
        @SerializedName("media_type") var mediaType: ItemType? = null,
        @GraphQLDescription("Item genre IDs")
        @SerializedName("genre_ids") var genreIds: ArrayList<Int> = arrayListOf(),
        @GraphQLIgnore
        @SerializedName("popularity") var popularity: Double? = null,
        @GraphQLDescription("Item release date")
        @SerializedName("first_air_date") var firstAirDate: String? = null,
        @GraphQLDescription("Vote average")
        @SerializedName("vote_average") var voteAverage: Double? = null,
        @GraphQLDescription("Vote count")
        @SerializedName("vote_count") var voteCount: Int? = null,
        @GraphQLDescription("Origin country")
        @SerializedName("origin_country") var originCountry: ArrayList<String> = arrayListOf()
    )
}
