package com.example.nikita.upgameskotlin

import android.app.Application
import com.example.nikita.upgameskotlin.di.components.AppComponent
import com.example.nikita.upgameskotlin.di.components.DaggerAppComponent
import com.example.nikita.upgameskotlin.di.modules.AppModule
import timber.log.Timber

/**
 * Created by nikita on 27.02.2018.
 */
class AppUpGames : Application() {

  private var sAppComponent: AppComponent? = null

  fun getAppComponent(): AppComponent? {
    return sAppComponent
  }
  override fun onCreate() {
    super.onCreate()
    sAppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}