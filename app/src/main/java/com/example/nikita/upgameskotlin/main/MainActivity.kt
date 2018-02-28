package com.example.nikita.upgameskotlin.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikita.upgameskotlin.R.id
import com.example.nikita.upgameskotlin.R.layout
import com.example.nikita.upgameskotlin.base.BaseActivity
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterAuthClient
import com.twitter.sdk.android.core.identity.TwitterLoginButton
import io.reactivex.Observable
import timber.log.Timber



class MainActivity : BaseActivity(), IMainActivityView {
  @InjectPresenter lateinit var mPresenter: MainActivityPresenter
  @BindView(id.tvHelloWorld) lateinit var tvHelloWorld: TextView
  @BindView(id.tlbLogin) lateinit var twitterButton: TwitterLoginButton

  /* вопросом помечаем, что может прийти null */
  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(layout.activity_main)
    super.onCreate(savedInstanceState)

    Observable.just("MainActivity kotlin Observable").subscribe({ Timber.e(it) })

    twitterButton.callback = object : Callback<TwitterSession>() {
      override fun success(result: Result<TwitterSession>) {
        Timber.e("twitter success")
        requestEmailAddress(applicationContext, result.data)
      }

      override fun failure(exception: TwitterException) {
        Timber.e("twitter failure")

      }
    }
  }

  private fun requestEmailAddress(context: Context, session: TwitterSession) {
    TwitterAuthClient().requestEmail(session, object : Callback<String>() {
      override fun success(result: Result<String>) {
        Toast.makeText(context, result.data, Toast.LENGTH_SHORT).show()
      }

      override fun failure(exception: TwitterException) {
        Toast.makeText(context, exception.message, Toast.LENGTH_SHORT).show()
      }
    })
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    twitterButton.onActivityResult(requestCode,resultCode,data)
  }
}
