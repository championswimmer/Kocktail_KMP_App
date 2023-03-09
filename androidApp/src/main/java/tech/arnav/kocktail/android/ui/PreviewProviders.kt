package tech.arnav.kocktail.android.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import tech.arnav.kocktail.api.Drink
import tech.arnav.kocktail.states.CocktailListState
import tech.arnav.kocktail.ui.IPreviewCocktailListProvider
import tech.arnav.kocktail.ui.IPreviewDrinksProvider

class PreviewDrinksProvider : IPreviewDrinksProvider(), PreviewParameterProvider<Drink>

class PreviewCocktailListProvider : IPreviewCocktailListProvider(),
    PreviewParameterProvider<CocktailListState>