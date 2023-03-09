package tech.arnav.kocktail.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tech.arnav.kocktail.api.CocktailAPI
import tech.arnav.kocktail.api.CocktailResponse
import tech.arnav.kocktail.states.CocktailListState

class CocktailListViewModel : KViewModel() {
    private val api = CocktailAPI()

    private val _state = MutableStateFlow<CocktailListState>(CocktailListState.Empty)
    val state: StateFlow<CocktailListState> = _state

    fun updateCocktailList() {
        _state.value = CocktailListState.Loading
        viewModelScope.launch {
            try {
                val response = api.getCocktails()
                _state.value = CocktailListState.Success(response)
            } catch (e: Exception) {
                _state.value = CocktailListState.Error(e)
            }
        }
    }
}