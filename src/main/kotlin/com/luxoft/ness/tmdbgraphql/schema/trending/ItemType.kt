package com.luxoft.ness.tmdbgraphql.schema.trending

enum class ItemType(val value: String) {
    MOVIE("movie"),
    TV_SHOW("tv"),
    PEOPLE("person"),
    ALL("all");

    override fun toString(): String {
        return value
    }
}