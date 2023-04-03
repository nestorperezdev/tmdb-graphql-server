package com.luxoft.ness.tmdbgraphql.query

import com.expediagroup.graphql.server.operations.Query
import com.luxoft.ness.tmdbgraphql.schema.Context
import com.luxoft.ness.tmdbgraphql.tmdb.TMDBApi
import com.luxoft.ness.tmdbgraphql.schema.trending.ItemType
import com.luxoft.ness.tmdbgraphql.schema.trending.TrendingData
import com.luxoft.ness.tmdbgraphql.schema.trending.TrendingTimePeriod
import com.luxoft.ness.tmdbgraphql.util.handleIfSuccessOrError
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import retrofit2.Response

@Controller
class TrendingTitlesQuery : Query {
    @Autowired
    private lateinit var tmdbApi: TMDBApi

    suspend fun trendingTitles(
        context: Context,
        pageNumber: Int,
        itemType: ItemType,
        timePeriod: TrendingTimePeriod
    ): TrendingData {
        return tmdbApi
            .trending(itemType = itemType, timePeriod = timePeriod, page = pageNumber, apiKey = context.token)
            .toTrendingData()
    }
}

fun Response<TrendingData>.toTrendingData() = this.handleIfSuccessOrError(
    success = { it },
    error = { TrendingData(error = it) }
)