package tech.arnav.kocktail.ui

import tech.arnav.kocktail.api.CocktailResponse
import tech.arnav.kocktail.api.Drink
import tech.arnav.kocktail.states.CocktailListState

interface PreviewParameterProvider<T> {
    /**
     * [Sequence] of values of type [T] to be passed as @[Preview] parameter.
     */
    val values: Sequence<T>
    val valuesAsArray: Array<T>
}

open class IPreviewDrinksProvider : PreviewParameterProvider<Drink> {
    override val values: Sequence<Drink>
        get() = sequenceOf(
            Drink(
                idDrink = "123",
                strDrink = "Mojito",
                strCategory = "Cocktail",
                strIngredient1 = "Rum",
                strIngredient2 = "Lime",
                strIngredient3 = "Sugar",
            )
        )
    override val valuesAsArray: Array<Drink> = values.toList().toTypedArray()
}

open class IPreviewCocktailListProvider : PreviewParameterProvider<CocktailListState> {
    val drinksProvider = IPreviewDrinksProvider()
    override val values: Sequence<CocktailListState>
        get() = sequenceOf(
            CocktailListState.Empty,
            CocktailListState.Loading,
            CocktailListState.Error(Throwable("Error")),
            CocktailListState.Success(
                CocktailResponse(
                    drinks = listOf(
                        drinksProvider.values.first(),
                    )
                )
            )
        )
    override val valuesAsArray: Array<CocktailListState> = values.toList().toTypedArray()

}

