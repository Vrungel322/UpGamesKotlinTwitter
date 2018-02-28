package com.example.nikita.upgameskotlin.api

import com.google.gson.annotations.SerializedName
import com.twitter.sdk.android.core.models.User

/**
 * Created by nikita on 28.02.2018.
 */
class UsersList {

  @JvmField
  @SerializedName("users")
  var users: List<User> = listOf()

}