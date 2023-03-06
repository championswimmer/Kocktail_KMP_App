package tech.arnav.kocktail.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import tech.arnav.kocktail.android.config.KocktailUIConfig
import tech.arnav.kocktail.android.ui.GreetingView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KocktailUIConfig.Theme {
                LazyColumn(content = {
                    items(10) {
                        GreetingView("Hello, Android!")
                    }
                })
            }
        }
    }
}