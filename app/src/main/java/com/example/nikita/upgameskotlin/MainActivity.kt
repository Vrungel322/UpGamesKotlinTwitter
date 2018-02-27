package com.example.nikita.upgameskotlin

import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import io.reactivex.Observable
import timber.log.Timber

class MainActivity : BaseActivity() {
  @BindView(R.id.tvHelloWorld) lateinit var tvHelloWorld: TextView
  /* вопросом помечаем, что может прийти null */
  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(R.layout.activity_main)
    super.onCreate(savedInstanceState)
    Timber.e("MainActivity kotlin")

    Observable.just("MainActivity kotlin Observable").subscribe({ Timber.e(it) });

    tvHelloWorld.text = "Changed Text"
  }
}
