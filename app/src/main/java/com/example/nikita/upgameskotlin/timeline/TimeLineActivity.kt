package com.example.nikita.upgameskotlin.timeline

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.widget.EditText
import butterknife.BindView
import butterknife.OnTextChanged
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikita.upgameskotlin.R
import com.example.nikita.upgameskotlin.base.BaseActivity
import com.twitter.sdk.android.tweetui.SearchTimeline
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter

class TimeLineActivity : BaseActivity(), ITimeLineActivityView {
  @InjectPresenter lateinit var mPresenter: TimeLineActivityPresenter

  @BindView(R.id.rvTimeLine) lateinit var mRecycleViewTimeLine: RecyclerView
  @BindView(R.id.etTimeLineQuery) lateinit var mEditTextTimeLineQuery: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(R.layout.activity_time_line)
    super.onCreate(savedInstanceState)
  }

  override fun setUpUi() {
    mRecycleViewTimeLine.layoutManager = LinearLayoutManager(applicationContext)
  }

  @OnTextChanged(value = R.id.etTimeLineQuery, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
  fun updateTimeLine(s: Editable) {

    val searchTimeline = SearchTimeline.Builder()
        .query("#"+s.toString())
        .maxItemsPerRequest(50)
        .build()

    val adapter = TweetTimelineRecyclerViewAdapter.Builder(applicationContext)
        .setTimeline(searchTimeline)
        .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
        .build()

    mRecycleViewTimeLine.adapter = adapter
  }
}
