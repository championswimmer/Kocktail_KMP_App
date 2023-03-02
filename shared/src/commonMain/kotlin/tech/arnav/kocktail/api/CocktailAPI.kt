package tech.arnav.kocktail.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class CocktailAPI {
    private val client = HttpClient(HttpEngineFactory.create()) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getCocktails(): CocktailResponse {
        val response =
            client.get("https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail")
        if (response.status.value != 200) {
            throw RuntimeException("Error fetching cocktails")
        }
        return response.body()
    }
}