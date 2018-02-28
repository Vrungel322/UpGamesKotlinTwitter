package com.example.nikita.upgameskotlin.api

import com.google.gson.annotations.SerializedName

/**
 * Created by nikita on 28.02.2018.
 */
/**
 * Gson object for a list of user ids.
 */
open class UserIdList {

  @JvmField
  @SerializedName("ids")
  var ids: List<Long> = listOf()

}