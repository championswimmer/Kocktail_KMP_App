package tech.arnav.kocktail.api

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual object HttpEngineFactory {
    actual fun create(): HttpClientEngine {
        return Darwin.create {
            configureRequest {
                setAllowsCellularAccess(true)
                setAllowsConstrainedNetworkAccess(true)
                setAllowsExpensiveNetworkAccess(true)
            }
        }
    }
}