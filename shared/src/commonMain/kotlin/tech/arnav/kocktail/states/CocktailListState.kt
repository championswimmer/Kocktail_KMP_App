package tech.arnav.kocktail.states

import tech.arnav.kocktail.api.CocktailResponse

sealed class CocktailListState {
    data class Success(val cocktails: CocktailResponse) : CocktailListState()
    data class Error(val error: Throwable) : CocktailListState()
    object Loading : CocktailListState()
    object Empty : CocktailListState()
}