package com.example.nikita.upgameskotlin.data

import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterAuthClient

/**
 * Created by vrungel on 28.02.2018.
 */
class SocialManager {
   var requestEmailListener: IRequestEmailListener?= null


  fun requestEmailAddress(session: TwitterSession) {
    TwitterAuthClient().requestEmail(session, object : Callback<String>() {
      override fun success(result: Result<String>) {
        requestEmailListener?.showToast(result.data);
      }

      override fun failure(exception: TwitterException) {
        requestEmailListener?.showToast(exception.message)
      }
    })
  }
}