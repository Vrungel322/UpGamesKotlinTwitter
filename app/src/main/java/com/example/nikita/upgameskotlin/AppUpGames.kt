package com.example.nikita.upgameskotlin

import android.app.Application
import timber.log.Timber

/**
 * Created by nikita on 27.02.2018.
 */
class AppUpGames : Application() {
  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}