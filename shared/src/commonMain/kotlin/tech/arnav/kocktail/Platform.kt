package tech.arnav.kocktail

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform