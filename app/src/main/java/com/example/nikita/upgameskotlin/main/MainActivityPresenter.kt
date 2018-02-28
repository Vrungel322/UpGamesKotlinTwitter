package com.example.nikita.upgameskotlin.main

import com.arellomobile.mvp.InjectViewState
import com.example.nikita.upgameskotlin.AppUpGames
import com.example.nikita.upgameskotlin.base.BasePresenter
import com.example.nikita.upgameskotlin.data.IRequestEmailListener
import com.example.nikita.upgameskotlin.data.SocialManager
import com.twitter.sdk.android.core.TwitterSession
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by nikita on 28.02.2018.
 */
@InjectViewState
class MainActivityPresenter : BasePresenter<IMainActivityView>() {
  @Inject lateinit var mSocailManager: SocialManager

  override fun init() {
    AppUpGames.sAppComponent.inject(this)
  }

  override fun onFirstViewAttach() {
    super.onFirstViewAttach()
    mSocailManager.requestEmailListener = object : IRequestEmailListener {
      override fun showToast(data: String?) {
        Timber.e(data)
        viewState.showToast(data)
      }
    }
  }

  fun requestEmailAddress(data: TwitterSession?) {
    data?.let { mSocailManager.requestEmailAddress(it) }
  }


}