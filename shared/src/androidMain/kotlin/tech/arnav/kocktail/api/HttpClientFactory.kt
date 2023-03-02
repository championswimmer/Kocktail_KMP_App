package tech.arnav.kocktail.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine
import okhttp3.OkHttpClient

actual class HttpClientFactory {
    actual fun create(): HttpClient {
        return HttpClient(OkHttpEngine(OkHttpConfig().apply {
            config {
                followRedirects(true)
                followSslRedirects(true)
            }
        }))
    }
}