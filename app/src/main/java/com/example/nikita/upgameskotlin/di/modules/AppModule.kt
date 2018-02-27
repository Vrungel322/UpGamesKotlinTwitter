package com.example.nikita.upgameskotlin.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by nikita on 27.02.2018.
 */
@Module
class AppModule(private val application: Application) {
  @Provides
  @Singleton
  fun provideApplicationContext(): Context = application

}