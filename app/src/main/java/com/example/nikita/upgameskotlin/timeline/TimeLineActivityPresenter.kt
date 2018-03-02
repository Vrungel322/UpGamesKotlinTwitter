package com.example.nikita.upgameskotlin.timeline

import com.arellomobile.mvp.InjectViewState
import com.example.nikita.upgameskotlin.AppUpGames
import com.example.nikita.upgameskotlin.base.BasePresenter

/**
 * Created by nikita on 02.03.2018.
 */
@InjectViewState
class TimeLineActivityPresenter : BasePresenter<ITimeLineActivityView>() {
  override fun init() {
    AppUpGames.sAppComponent.inject(this)
  }

}