package com.example.nikita.upgameskotlin.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikita.upgameskotlin.R.id
import com.example.nikita.upgameskotlin.R.layout
import com.example.nikita.upgameskotlin.base.BaseActivity
import com.example.nikita.upgameskotlin.timeline.TimeLineActivity
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterLoginButton
import com.twitter.sdk.android.tweetcomposer.TweetComposer
import timber.log.Timber


class MainActivity : BaseActivity(), IMainActivityView {
  @InjectPresenter lateinit var mPresenter: MainActivityPresenter

  @BindView(id.tlbLogin) lateinit var twitterButton: TwitterLoginButton
  /* вопросом помечаем, что может прийти null */
  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(layout.activity_main)
    super.onCreate(savedInstanceState)
  }

  override fun setUpUi() {
    twitterButton.callback = object : Callback<TwitterSession>() {
      override fun success(result: Result<TwitterSession>) {
        Timber.e("twitter success")
        mPresenter.requestEmailAddress(result.data)
      }

      override fun failure(exception: TwitterException) {
        Timber.e("twitter failure")
        Timber.e("twitter failure " + exception.localizedMessage)

      }
    }
  }

  @OnClick(id.bSendPost)
  fun bSendPostClicked() {
    TweetComposer.Builder(this).show()
  }

  @OnClick(id.bTimeLine)
  fun bTimeLineClick() {
    startActivity(Intent(this@MainActivity, TimeLineActivity::class.java))
  }

  override fun showToast(data: String?) {
    Toast.makeText(applicationContext, data, Toast.LENGTH_SHORT).show()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    twitterButton.onActivityResult(requestCode, resultCode, data)
  }
}
