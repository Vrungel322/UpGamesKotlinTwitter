package com.example.nikita.upgameskotlin.di.components

import com.example.nikita.upgameskotlin.di.modules.AppModule
import com.example.nikita.upgameskotlin.main.MainActivityPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by nikita on 27.02.2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
  fun inject(mainPresenter : MainActivityPresenter)
}