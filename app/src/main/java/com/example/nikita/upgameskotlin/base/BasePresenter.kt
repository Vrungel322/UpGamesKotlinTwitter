package com.example.nikita.upgameskotlin.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.example.nikita.upgameskotlin.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by nikita on 27.02.2018.
 */
abstract class BasePresenter<V : MvpView>() : MvpPresenter<V>() {
    @Inject lateinit var mDataManager: DataManager

    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Timber.e(mDataManager.getString());
    }

    init {
        init()
    }

    fun addToUnsubscription(subscription: Disposable?) {
        mCompositeDisposable.add(subscription)
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable.clear()
    }

    abstract fun init()
}