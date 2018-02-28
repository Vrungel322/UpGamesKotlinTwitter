package com.example.nikita.upgameskotlin.di.modules

import com.example.nikita.upgameskotlin.data.SocialManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by vrungel on 28.02.2018.
 */
@Module
class DataModule {

  @Provides
  @Singleton
  fun provideSocialManager(): SocialManager = SocialManager()
}