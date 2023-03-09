package tech.arnav.kocktail.viewmodel

import kotlinx.coroutines.CoroutineScope

expect abstract class KViewModel() {
    val viewModelScope: CoroutineScope
    protected open fun onCleared()
}