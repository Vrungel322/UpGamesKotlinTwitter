package com.example.nikita.upgameskotlin.main

import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikita.upgameskotlin.R.id
import com.example.nikita.upgameskotlin.R.layout
import com.example.nikita.upgameskotlin.base.BaseActivity
import io.reactivex.Observable
import timber.log.Timber

class MainActivity : BaseActivity(), IMainActivityView {
  @InjectPresenter lateinit var mPresenter: MainActivityPresenter
  @BindView(id.tvHelloWorld) lateinit var tvHelloWorld: TextView

  /* вопросом помечаем, что может прийти null */
  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(layout.activity_main)
    super.onCreate(savedInstanceState)
    Timber.e("MainActivity kotlin")

    Observable.just("MainActivity kotlin Observable").subscribe({ Timber.e(it) });

    tvHelloWorld.text = "Changed Text"
  }
}
