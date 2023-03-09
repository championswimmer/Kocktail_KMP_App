package tech.arnav.kocktail.viewmodel

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tech.arnav.kocktail.api.CocktailAPI
import tech.arnav.kocktail.states.CocktailListState

class CocktailListViewModel : KMMViewModel() {
    private val api = CocktailAPI()

    private val _state = MutableStateFlow<CocktailListState>(CocktailListState.Empty)

    @NativeCoroutinesState
    val state: StateFlow<CocktailListState> = _state

    fun updateCocktailList() {
        _state.value = CocktailListState.Loading
        viewModelScope.coroutineScope.launch {
            try {
                val response = api.getCocktails()
                _state.value = CocktailListState.Success(response)
            } catch (e: Exception) {
                _state.value = CocktailListState.Error(e)
            }
        }
    }
}