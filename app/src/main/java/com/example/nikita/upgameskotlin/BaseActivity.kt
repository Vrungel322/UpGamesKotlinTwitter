package com.example.nikita.upgameskotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife

/**
 * Created by nikita on 27.02.2018.
 */
open class BaseActivity : AppCompatActivity(){
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    ButterKnife.bind(this)
  }
}