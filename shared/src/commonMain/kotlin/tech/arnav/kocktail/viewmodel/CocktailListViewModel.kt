package tech.arnav.kocktail.viewmodel

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tech.arnav.kocktail.api.CocktailAPI
import tech.arnav.kocktail.states.CocktailListState

class CocktailListViewModel : KMMViewModel() {
    private val api = CocktailAPI()

    private val _cocktailState = MutableStateFlow<CocktailListState>(CocktailListState.Empty)

    @NativeCoroutinesState
    val cocktailState: StateFlow<CocktailListState> = _cocktailState.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(), CocktailListState.Empty
    )

    fun updateCocktailList() {
        _cocktailState.value = CocktailListState.Loading
        viewModelScope.coroutineScope.launch {
            try {
                val response = api.getCocktails()
                _cocktailState.value = CocktailListState.Success(response)
            } catch (e: Exception) {
                _cocktailState.value = CocktailListState.Error(e)
            }
        }
    }
}