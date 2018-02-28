package com.example.nikita.upgameskotlin

import android.app.Application
import com.example.nikita.upgameskotlin.di.components.AppComponent
import com.example.nikita.upgameskotlin.di.components.DaggerAppComponent
import com.example.nikita.upgameskotlin.di.modules.AppModule
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import timber.log.Timber



/**
 * Created by nikita on 27.02.2018.
 */
class AppUpGames : Application() {

  companion object {
    lateinit var sAppComponent: AppComponent
  }

  override fun onCreate() {
    super.onCreate()
    sAppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }

    val config = TwitterConfig.Builder(this)
        .logger(DefaultLogger())
        .twitterAuthConfig(TwitterAuthConfig("pmRtEhpmGF4fhxPWhOMMZ7bjV", "KNwXo82bZhB2j5iU20O0pt2aj4uQusxHWiblu0KkQOS6BkPFX8"))
        .debug(true)
        .build()
    Twitter.initialize(config)
  }
}