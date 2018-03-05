package com.example.nikita.upgameskotlin.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikita.upgameskotlin.R.layout
import com.example.nikita.upgameskotlin.base.BaseActivity
import com.example.nikita.upgameskotlin.timeline.TimeLineActivity
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import kotlinx.android.synthetic.main.activity_main.tlbLogin
import timber.log.Timber


class MainActivity : BaseActivity(), IMainActivityView {
  @InjectPresenter lateinit var mPresenter: MainActivityPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(layout.activity_main)
    super.onCreate(savedInstanceState)
  }

  override fun setUpUi() {
    tlbLogin.callback = object : Callback<TwitterSession>() {
      override fun success(result: Result<TwitterSession>) {
        Timber.e("twitter success name: " + result.data.userName)
        mPresenter.fillUser(result.data.userName)
        mPresenter.requestEmailAddress(result.data)
        startActivity(Intent(this@MainActivity, TimeLineActivity::class.java))

      }

      override fun failure(exception: TwitterException) {
        Timber.e("twitter failure")
        Timber.e("twitter failure " + exception.localizedMessage)
      }
    }
  }

//  @OnClick(id.bSendPost)
//  fun bSendPostClicked() {
//    TweetComposer.Builder(this).show()
//  }

  override fun showToast(data: String?) {
    Toast.makeText(applicationContext, data, Toast.LENGTH_SHORT).show()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    tlbLogin.onActivityResult(requestCode, resultCode, data)
  }
}
