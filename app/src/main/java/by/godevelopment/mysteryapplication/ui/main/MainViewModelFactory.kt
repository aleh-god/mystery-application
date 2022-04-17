package by.godevelopment.mysteryapplication.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.godevelopment.mysteryapplication.commons.TAG
import by.godevelopment.mysteryapplication.domain.ColdStartHandler

class MainViewModelFactory(
    private val coldStartHandler: ColdStartHandler
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.i(TAG, "MainViewModelFactory create")
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(coldStartHandler) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
