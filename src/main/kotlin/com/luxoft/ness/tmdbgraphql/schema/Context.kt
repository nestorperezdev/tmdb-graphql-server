package com.luxoft.ness.tmdbgraphql.schema

import com.expediagroup.graphql.generator.annotations.GraphQLDescription

data class Context(@GraphQLDescription("TMDB API Token") val token: String)