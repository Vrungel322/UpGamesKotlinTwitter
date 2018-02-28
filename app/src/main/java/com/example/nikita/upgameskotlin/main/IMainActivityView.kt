package com.example.nikita.upgameskotlin.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by nikita on 28.02.2018.
 */
@StateStrategyType(value = AddToEndSingleStrategy::class)
interface IMainActivityView : MvpView {
}