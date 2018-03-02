package com.example.nikita.upgameskotlin.timeline

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by nikita on 02.03.2018.
 */
@StateStrategyType(value = AddToEndSingleStrategy::class)
interface ITimeLineActivityView : MvpView {
}