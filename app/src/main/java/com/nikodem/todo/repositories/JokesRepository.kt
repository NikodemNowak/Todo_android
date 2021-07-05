package com.nikodem.todo.repositories

import com.nikodem.todo.services.JokesApiService
import com.nikodem.todo.services.JokesResponse

interface JokesRepository {
    suspend fun getRandomJoke(): JokesResponse
}

class JokesApiRepository(
    private val jokesApiService: JokesApiService
) : JokesRepository {
    override suspend fun getRandomJoke(): JokesResponse {
        return jokesApiService.getRandomJoke()
    }
}