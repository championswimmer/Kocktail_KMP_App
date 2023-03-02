package tech.arnav.kocktail.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine

expect object HttpEngineFactory {
    fun create(): HttpClientEngine
}