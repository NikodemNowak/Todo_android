package com.nikodem.todo.services

import retrofit2.http.GET

interface CatApiService {

    @GET("v1/images/search")
    suspend fun getRandomCat(): List<RandomCatResponse>
}