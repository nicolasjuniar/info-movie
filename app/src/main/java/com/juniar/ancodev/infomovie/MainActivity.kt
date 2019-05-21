package com.juniar.ancodev.infomovie

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.juniar.ancodev.infomovie.BuildConfig.POSTER_URL
import com.juniar.ancodev.infomovie.data.MovieModel
import com.juniar.ancodev.infomovie.utils.getCountLine
import juniar.common.androidx.base.BaseActivity
import juniar.common.androidx.helper.DiffCallback
import juniar.common.androidx.helper.GeneralRecyclerView
import juniar.common.androidx.utils.loadImage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.viewholder_movie.view.*
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    lateinit var diffCallback: DiffCallback

    @Inject
    lateinit var mainViewModel: MainViewModel

    private val nowPlayingAdapter by lazy {
        GeneralRecyclerView<MovieModel>(
            diffCallback = diffCallback,
            holderResId = R.layout.viewholder_movie,
            onBind = { movieModel, view ->
                view.iv_poster.loadImage("$POSTER_URL/${movieModel.backdropPath}")
                view.tv_movie_title.text = movieModel.originalTitle
                view.tv_release_date.text = movieModel.releaseDate
                view.tv_rating.text = movieModel.voteAverage.toString()
                view.tv_description.text = movieModel.overview
                view.tv_description.maxLines -= (view.tv_movie_title.getCountLine() - 1)
//                Log.d("line count dari ${movieModel.originalTitle}", view.tv_movie_title.getCountLine().toString())
            },
            itemListener = { _, _, _ ->

            }
        )
    }

    override fun onSetupLayout(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        with(rv_now_playing) {
            adapter = nowPlayingAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        with(mainViewModel) {
            observeNowPlaying().onResult { result ->
                result?.let {
                    nowPlayingAdapter.setData(it)
                }
            }

            boundNetwork {
                if (it) {
                    getNowPlaying()
                }
            }
        }

    }

}