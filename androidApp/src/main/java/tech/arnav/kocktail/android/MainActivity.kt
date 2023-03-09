@file:OptIn(ExperimentalMaterialApi::class)

package tech.arnav.kocktail.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.collectAsState
import tech.arnav.kocktail.android.config.KocktailUIConfig
import tech.arnav.kocktail.android.ui.CocktailListView
import tech.arnav.kocktail.viewmodel.CocktailListViewModel

class MainActivity : ComponentActivity() {
    val viewModel: CocktailListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KocktailUIConfig.Theme {
                val state = viewModel.cocktailState.collectAsState()
                CocktailListView(
                    state = state.value,
                    onRefresh = { viewModel.updateCocktailList() }
                )
            }
        }
    }
}

