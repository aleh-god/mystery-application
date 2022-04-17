package by.godevelopment.mysteryapplication.domain

import android.util.Log
import by.godevelopment.mysteryapplication.commons.COLD_START_VALUE
import by.godevelopment.mysteryapplication.commons.TAG
import by.godevelopment.mysteryapplication.data.MysterySharedPreference

class ColdStartHandler(
    private val mysterySharedPreference: MysterySharedPreference
) {
    fun checkCounterColdStart(): Boolean {
        val valueCounter = mysterySharedPreference.getCountValue()
        Log.i(TAG, "checkCounterColdStart $valueCounter")
        return valueCounter == COLD_START_VALUE
    }

    fun resetCounterColdStart() {
        mysterySharedPreference.resetCountValue()
        Log.i(TAG, "resetCounterColdStart")
    }
}