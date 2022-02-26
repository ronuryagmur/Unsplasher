package com.ronur.unsplasher

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.ronur.unsplasher.utils.ExtUtils
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        setupDayNightMode()
    }

    private fun setupDayNightMode() {
        // Get UI mode and set
        val mode = if (false) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }

        AppCompatDelegate.setDefaultNightMode(mode)
    }
}