package by.godevelopment.mysteryapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import by.godevelopment.mysteryapplication.commons.TAG
import by.godevelopment.mysteryapplication.data.MysterySharedPreference
import by.godevelopment.mysteryapplication.domain.ColdStartHandler
import by.godevelopment.mysteryapplication.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    val coldStartHandler: ColdStartHandler by lazy {
        Log.i(TAG, "MainActivity by lazy: coldStartHandler")
        ColdStartHandler(MysterySharedPreference(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}