# Spring backend with GraphQL for TMDB

[![Project Build](https://github.com/nestorperezdev/registry-backend/actions/workflows/build.yaml/badge.svg?branch=master)](https://github.com/nestorperezdev/registry-backend/actions/workflows/build.yaml)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

This application is a wrapper around the The movie DB (v3)

The developer can use his own tmdb api token to get data on GraphQL format.

This app makes use of [ExpediaGroup](https://github.com/ExpediaGroup/graphql-kotlin) open source graphql kotlin library.

In order to obtain a functional token for this API visit: https://developers.themoviedb.org/3/getting-started/introduction

## 📋 Requirements

For building and running the application you need:

#zulu 11 url
- [JDK 11](https://www.azul.com/downloads/#zulu)
- [Gradle 7.6.1](https://gradle.org/releases/)

## 🛠️ Building the application
```shell
./gradlew assemble
```

## 🛠 Docker image building
```shell
docker build . -t tmdb-graphql-server:1.0.0
```

## 🚀 Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.luxoft.ness.tmdbgraphql.TheMovieDbGraphQlApiWrapper.kt` class from your IDE.

Alternatively you can use the gradlew command:

```shell
./gradlew bootRun
```

## 🧪 Running the tests
```shell
./gradlew clean test
```

## 📦 Usage
For use this app you can visit:

* http://localhost:8080/playground: Inspect the schema and run queries.
* http://localhost:8080/graphql: Download schema


## 📝 License

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.