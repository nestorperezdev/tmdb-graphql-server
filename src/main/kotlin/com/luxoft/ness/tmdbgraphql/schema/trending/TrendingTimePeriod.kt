package com.luxoft.ness.tmdbgraphql.schema.trending

enum class TrendingTimePeriod(val value: String) {
    DAY("day"),
    WEEK("week");

    override fun toString(): String {
        return value
    }
}