package tech.arnav.kocktail.db

import app.cash.sqldelight.db.SqlDriver

expect class SqlDriverFactory {
    fun createDriver(): SqlDriver
}