package tech.arnav.kocktail.android.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import tech.arnav.kocktail.android.config.KocktailUIConfig

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun GreetingViewPreview() {
    KocktailUIConfig.Theme {
        GreetingView("Hello, Android!")
    }
}