package by.godevelopment.mysteryapplication

import android.app.Application
import android.util.Log
import by.godevelopment.mysteryapplication.commons.TAG
import by.godevelopment.mysteryapplication.data.MysterySharedPreference

class MysteryApp : Application() {

    override fun onCreate() {
        countingColdStart()
        super.onCreate()
    }

    private fun countingColdStart() {
        Log.i(TAG, "countingColdStart: invoke")
        val mysterySharedPreference = MysterySharedPreference(this)
        mysterySharedPreference.increaseCountValue()
    }
}