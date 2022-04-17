package by.godevelopment.mysteryapplication.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.godevelopment.mysteryapplication.commons.TAG
import by.godevelopment.mysteryapplication.domain.ColdStartHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val coldStartHandler: ColdStartHandler
) : ViewModel() {

    private val _uiEvent  = MutableSharedFlow<Boolean>(0)
    val uiEvent: SharedFlow<Boolean> = _uiEvent

    init {
        Log.i(TAG, "MainViewModel: init")
        viewModelScope.launch {
            delay(1000)
            checkCounterColdStart()
        }
    }

    private fun checkCounterColdStart() {
        if (coldStartHandler.checkCounterColdStart()) {
            viewModelScope.launch {
                _uiEvent.emit(true)
                Log.i(TAG, "MainViewModel: _uiEvent.emit ${coldStartHandler.checkCounterColdStart()}")
            }
        }
    }

    fun resetCounterColdStart() {
        coldStartHandler.resetCounterColdStart()
        Log.i(TAG, "MainViewModel: resetCounterColdStart")
    }
}