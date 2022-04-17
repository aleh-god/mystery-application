package by.godevelopment.mysteryapplication.data

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import by.godevelopment.mysteryapplication.commons.TAG

class MysterySharedPreference (appContext: Context) {

    private val sharedPreferences = appContext
        .getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun increaseCountValue() {
        var currentValue = getCountValue()
        setCountValue(++currentValue)
        Log.i(TAG, "increaseCountValue: $currentValue")
    }

    fun resetCountValue() {
        Log.i(TAG, "resetCountValue")
        setCountValue(0)
    }

    private fun setCountValue(count: Int) {
        Log.i(TAG, "setCountValue $count")
        sharedPreferences.edit { putInt(PREF_COUNT_KEY, count) }
    }

    fun getCountValue(): Int = sharedPreferences.getInt(PREF_COUNT_KEY, NO_PARTY_KEY)

    companion object {
        private const val PREFERENCE_NAME = "mystery_cold_start_count"
        private const val PREF_COUNT_KEY = "count_key"
        const val NO_PARTY_KEY = 0
    }
}