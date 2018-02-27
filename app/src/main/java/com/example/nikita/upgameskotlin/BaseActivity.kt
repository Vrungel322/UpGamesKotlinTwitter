package com.example.nikita.upgameskotlin

import android.os.Bundle
import butterknife.ButterKnife
import com.arellomobile.mvp.MvpActivity

/**
 * Created by nikita on 27.02.2018.
 */
open class BaseActivity : MvpActivity(){
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    ButterKnife.bind(this)
  }
}