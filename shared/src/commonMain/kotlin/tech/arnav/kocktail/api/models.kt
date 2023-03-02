package tech.arnav.kocktail.api


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class CocktailResponse(
    val drinks: List<Drink>
)

@Serializable
data class Drink(
    val idDrink: String,
    val strDrink: String,
    val strDrinkAlternate: JsonElement? = null,
    val strTags: String,
    val strVideo: JsonElement? = null,
    val strCategory: String,
    val strIBA: JsonElement? = null,
    val strAlcoholic: String,
    val strGlass: String,
    val strInstructions: String,
    val strDrinkThumb: String,
    val strIngredient1: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: JsonElement? = null,
    val strIngredient6: JsonElement? = null,
    val strIngredient7: JsonElement? = null,
    val strIngredient8: JsonElement? = null,
    val strMeasure1: String,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String,
    val strMeasure5: String,
    val strMeasure6: String,
    val strMeasure7: String,
    val strMeasure8: JsonElement? = null,
    val strImageSource: JsonElement? = null,
    val strImageAttribution: JsonElement? = null,
    val strCreativeCommonsConfirmed: String,
    val dateModified: JsonElement? = null
)