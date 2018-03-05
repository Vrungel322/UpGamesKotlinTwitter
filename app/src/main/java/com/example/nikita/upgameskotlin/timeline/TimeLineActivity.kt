package com.example.nikita.upgameskotlin.timeline

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikita.upgameskotlin.R
import com.example.nikita.upgameskotlin.base.BaseActivity
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter
import com.twitter.sdk.android.tweetui.UserTimeline
import kotlinx.android.synthetic.main.activity_time_line.rvTimeLine


class TimeLineActivity : BaseActivity(), ITimeLineActivityView {
    @InjectPresenter lateinit var mPresenter: TimeLineActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_time_line)
        super.onCreate(savedInstanceState)
    }

    override fun setUpUi() {
        rvTimeLine.layoutManager = LinearLayoutManager(applicationContext)

        val userTimeline = UserTimeline.Builder()
                .build()

        val adapter = TweetTimelineRecyclerViewAdapter.Builder(applicationContext)
                .setTimeline(userTimeline)
                .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                .build()

        rvTimeLine.adapter = adapter
    }

}
