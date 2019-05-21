package com.juniar.ancodev.infomovie.network

import com.juniar.ancodev.infomovie.BuildConfig.LANGUAGE
import com.juniar.ancodev.infomovie.data.NowPlayingResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("movie/now_playing")
    fun getNowPlaying(
        @Query("language") language: String = LANGUAGE,
        @Query("page") page: Int = 1
    ): Single<NowPlayingResponse>
}