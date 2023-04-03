package com.luxoft.ness.tmdbgraphql.schema.images

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.google.gson.annotations.SerializedName
import com.luxoft.ness.tmdbgraphql.util.handleIfSuccessOrError
import retrofit2.Response

data class MovieImages(
    @SerializedName("backdrops") var backdrops: List<Image> = emptyList(),
    @GraphQLIgnore
    @SerializedName("id") var id: Int? = null,
    @SerializedName("logos") var logos: List<Image> = emptyList(),
    @SerializedName("posters") var posters: List<Image> = emptyList(),
    @GraphQLDescription("Error message, null if no error")
    var error: String? = null
) {
    data class Image(
        @SerializedName("aspect_ratio") var aspectRatio: Double? = null,
        @SerializedName("height") var height: Int? = null,
        @SerializedName("iso_639_1") var iso6391: String? = null,
        @SerializedName("file_path") var filePath: String? = null,
        @SerializedName("vote_average") var voteAverage: Double? = null,
        @SerializedName("vote_count") var voteCount: Int? = null,
        @SerializedName("width") var width: Int? = null
    )
}

fun Response<MovieImages>.toMovieImages(): MovieImages {
    return handleIfSuccessOrError(success = { it }, error = { MovieImages(error = it) })
}
