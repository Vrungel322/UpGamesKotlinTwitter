package com.example.nikita.upgameskotlin.main

import com.example.nikita.upgameskotlin.AppUpGames
import com.example.nikita.upgameskotlin.base.BasePresenter

/**
 * Created by nikita on 28.02.2018.
 */
class MainActivityPresenter : BasePresenter<IMainActivityView>() {
  override fun init() {
    AppUpGames.sAppComponent.inject(this)
  }
}