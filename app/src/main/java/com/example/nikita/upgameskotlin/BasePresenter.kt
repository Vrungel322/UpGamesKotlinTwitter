package com.example.nikita.upgameskotlin

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by nikita on 27.02.2018.
 */
abstract class BasePresenter<V : MvpView>() : MvpPresenter<V>() {
  lateinit var mCompositeSubscribtion: CompositeSubscription

  init {
    init()
  }

  fun addToUnsubscription(subscription: Subscription) {
    mCompositeSubscribtion.add(subscription)
  }

  override fun onDestroy() {
    super.onDestroy()
    mCompositeSubscribtion.clear()
  }

  abstract fun init()
}