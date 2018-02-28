package com.example.nikita.upgameskotlin.main

import com.example.nikita.upgameskotlin.AppUpGames
import com.example.nikita.upgameskotlin.base.BasePresenter
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterAuthClient

/**
 * Created by nikita on 28.02.2018.
 */
class MainActivityPresenter : BasePresenter<IMainActivityView>() {
  override fun init() {
    AppUpGames.sAppComponent.inject(this)
  }

  fun requestEmailAddress( session: TwitterSession) {
    TwitterAuthClient().requestEmail(session, object : Callback<String>() {
      override fun success(result: Result<String>) {
        viewState.showToast(result.data);
      }

      override fun failure(exception: TwitterException) {
        viewState.showToast(exception.message)
      }
    })
  }
}