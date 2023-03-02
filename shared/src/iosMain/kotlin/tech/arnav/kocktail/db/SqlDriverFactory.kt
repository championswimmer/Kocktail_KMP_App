package tech.arnav.kocktail.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class SqlDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(CocktailDB.Schema, "cocktail.db")
    }

}