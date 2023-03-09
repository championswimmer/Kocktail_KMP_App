package tech.arnav.kocktail.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.arnav.kocktail.android.config.KocktailUIConfig
import tech.arnav.kocktail.api.Drink

@Composable
fun CocktailItemRowView(drink: Drink) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = 4.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = drink.strDrink ?: "", Modifier.padding(12.dp),
                style = KocktailUIConfig.typography().subtitle1
            )
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = arrayOf(
                        drink.strIngredient1,
                        drink.strIngredient2,
                        drink.strIngredient3
                    ).joinToString(",") { it ?: "" },
                    Modifier.padding(12.dp),
                    style = KocktailUIConfig.typography().caption,
                )
            }
            Text(
                text = drink.strCategory ?: "", Modifier.padding(12.dp),
                style = KocktailUIConfig.typography().subtitle2
            )
        }
    }
}


@Preview
@Composable
fun CocktailRowPreview() {
    val drink = Drink(
        idDrink = "123",
        strDrink = "Mojito",
        strCategory = "Cocktail",
        strIngredient1 = "Rum",
        strIngredient2 = "Lime",
        strIngredient3 = "Sugar",
    )
    KocktailUIConfig.Theme {
        Column {
            CocktailItemRowView(drink)
            CocktailItemRowView(drink)
            CocktailItemRowView(drink)
        }
    }

}