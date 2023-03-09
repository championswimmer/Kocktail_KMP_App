package tech.arnav.kocktail.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import tech.arnav.kocktail.states.CocktailListState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CocktailListView(
    state: CocktailListState,
    onRefresh: () -> Unit,
    pullRefreshState: PullRefreshState = rememberPullRefreshState(
        refreshing = state is CocktailListState.Loading,
        onRefresh = onRefresh
    ),
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(
                state = pullRefreshState,
                enabled = true
            )
    ) {
        when (state) {
            is CocktailListState.Success -> {
                LazyColumn {
                    items(
                        items = state.cocktails.drinks,
                        itemContent = { CocktailItemRowView(drink = it) },
                        key = { it.idDrink!! },
                    )
                }

            }

            is CocktailListState.Error -> {
                Text(text = "Error: ${state.error.message}")
            }

            CocktailListState.Loading -> {
                PullRefreshIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    refreshing = true,
                    state = pullRefreshState
                )
            }

            CocktailListState.Empty -> {
                Button(
                    onClick = onRefresh,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text(text = "Tap to refresh")
                }
            }
        }
    }
}