package com.nikodem.todo.services

import retrofit2.http.GET

interface JokesApiService {

    @GET("random")
    suspend fun getRandomJoke(): JokesResponse
}