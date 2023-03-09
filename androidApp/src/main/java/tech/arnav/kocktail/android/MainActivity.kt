@file:OptIn(ExperimentalMaterialApi::class)

package tech.arnav.kocktail.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.arnav.kocktail.android.config.KocktailUIConfig
import tech.arnav.kocktail.android.ui.CocktailListView
import tech.arnav.kocktail.viewmodel.CocktailListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KocktailUIConfig.Theme {
                MainActivityScreen()
            }
        }
    }
}

@Composable
fun MainActivityScreen(
    viewModel: CocktailListViewModel = viewModel()
) {
    val state = viewModel.cocktailState.collectAsState()
    CocktailListView(
        state = state.value,
        onRefresh = { viewModel.updateCocktailList() }
    )
}
