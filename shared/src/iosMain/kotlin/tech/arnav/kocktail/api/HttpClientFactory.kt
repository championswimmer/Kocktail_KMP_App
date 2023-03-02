package tech.arnav.kocktail.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

actual class HttpClientFactory {
    actual fun create(): HttpClient {
        return HttpClient(Darwin.create {
            configureRequest {
                setAllowsCellularAccess(true)
                setAllowsConstrainedNetworkAccess(true)
                setAllowsExpensiveNetworkAccess(true)
            }
        })
    }
}