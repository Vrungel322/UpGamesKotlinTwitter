package com.example.nikita.upgameskotlin.data

import com.example.nikita.upgameskotlin.api.KTwitterApi
import com.twitter.sdk.android.core.models.Tweet
import com.twitter.sdk.android.core.models.User
import rx.Observable

/**
 * Created by nikita on 05.03.2018.
 */
class RestApi {

  private var api: KTwitterApi? = null

  constructor(kTwitterApi: KTwitterApi) {
    api = kTwitterApi
  }

  fun fetchTweets(userId: Long, count: Int): Observable<List<Tweet>>? = api?.userTimeline(
      userId, count = 0)

  fun getUser(screenName: String,
      includeEntities: Boolean = true): Observable<User>? = api?.getUser(screenName,
      includeEntities)
}