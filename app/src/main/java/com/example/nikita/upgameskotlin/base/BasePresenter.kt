package com.example.nikita.upgameskotlin.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.example.nikita.upgameskotlin.data.DataManager
import rx.Subscription
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by nikita on 27.02.2018.
 */
abstract class BasePresenter<V : MvpView>() : MvpPresenter<V>() {
  @Inject lateinit var mDataManager: DataManager

  override fun onFirstViewAttach() {
    super.onFirstViewAttach()
    Timber.e(mDataManager.getString());
  }

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