package com.nikodem.todo.services

data class JokesResponse(
    val type: String,
    val value: Value
)

data class Value(
    val id: Long,
    val joke: String,
    val categories: List<Any?>
)
