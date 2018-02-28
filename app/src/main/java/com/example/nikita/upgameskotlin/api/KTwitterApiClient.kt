package com.example.nikita.upgameskotlin.api

import com.twitter.sdk.android.core.TwitterApiClient
import com.twitter.sdk.android.core.TwitterSession

/**
 * Created by nikita on 28.02.2018.
 */
class KTwitterApiClient(val session: TwitterSession) : TwitterApiClient(session) {

  val kTwitterApi: KTwitterApi by lazy { getService(KTwitterApi::class.java) }
}