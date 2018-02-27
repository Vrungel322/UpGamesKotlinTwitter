package com.example.nikita.upgameskotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import timber.log.Timber

class MainActivity : AppCompatActivity() {
  /* вопросом помечаем, что может прийти null */
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    Timber.e("MainActivity kotlin")

    Observable.just("MainActivity kotlin Observable").subscribe({ Timber.e(it) });
  }
}
