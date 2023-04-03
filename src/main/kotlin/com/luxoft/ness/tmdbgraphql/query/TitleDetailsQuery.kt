package com.luxoft.ness.tmdbgraphql.query

import com.expediagroup.graphql.server.operations.Query
import com.luxoft.ness.tmdbgraphql.schema.Context
import com.luxoft.ness.tmdbgraphql.schema.details.TitleDetailsModel
import com.luxoft.ness.tmdbgraphql.schema.details.toTitleDetailsModel
import com.luxoft.ness.tmdbgraphql.tmdb.model.TitleDetails
import com.luxoft.ness.tmdbgraphql.tmdb.TMDBApi
import com.luxoft.ness.tmdbgraphql.util.handleIfSuccessOrError
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import retrofit2.Response

@Controller
class TitleDetailsQuery : Query {
    @Autowired
    lateinit var tmdbApi: TMDBApi

    suspend fun titleDetails(context: Context, movieId: Int): TitleDetailsModel {
        return tmdbApi.details(apiKey = context.token, movieId = movieId)
            .toTitleDetailsModel(context = context, movieId = movieId)
    }
}

fun Response<TitleDetails>.toTitleDetailsModel(context: Context, movieId: Int): TitleDetailsModel {
    return handleIfSuccessOrError(
        success = {
            it.toTitleDetailsModel(context, null, id = movieId)
        },
        error = { TitleDetailsModel(context = context, error = it, id = movieId) }
    )
}
