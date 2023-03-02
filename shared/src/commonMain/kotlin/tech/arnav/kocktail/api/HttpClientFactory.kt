package tech.arnav.kocktail.api

import io.ktor.client.HttpClient

expect class HttpClientFactory {
    fun create(): HttpClient
}