package com.nikodem.todo.repositories

import com.nikodem.todo.services.CatApiService
import com.nikodem.todo.services.RandomCatResponse

interface CatRepository {
    suspend fun getRandomCat(): RandomCatResponse
}

class CatApiRepository(
    private val catApiService: CatApiService
) : CatRepository {
    override suspend fun getRandomCat(): RandomCatResponse {
        return catApiService.getRandomCat()[0]
    }
}