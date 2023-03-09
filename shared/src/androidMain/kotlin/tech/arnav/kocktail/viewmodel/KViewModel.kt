package tech.arnav.kocktail.viewmodel

import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.ViewModel as AndroidXViewModel
import androidx.lifecycle.viewModelScope as androidXViewModelScope

actual abstract class KViewModel : AndroidXViewModel()  {
    actual val viewModelScope = androidXViewModelScope

    protected actual override fun onCleared() {
    }
}