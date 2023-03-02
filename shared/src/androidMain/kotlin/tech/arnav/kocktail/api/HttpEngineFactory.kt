package tech.arnav.kocktail.api

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine

actual object HttpEngineFactory {
    actual fun create(): HttpClientEngine {
        return OkHttpEngine(OkHttpConfig().apply {
            config {
                followRedirects(true)
                followSslRedirects(true)
            }
        })
    }
}