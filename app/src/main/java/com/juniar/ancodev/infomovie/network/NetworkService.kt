package com.juniar.ancodev.infomovie.network

import com.juniar.ancodev.infomovie.BuildConfig.API_KEY
import com.juniar.ancodev.infomovie.BuildConfig.LANGUAGE
import com.juniar.ancodev.infomovie.data.NowPlayingResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("movie/now_playing")
    fun getNowPlaying(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
        @Query("page") page: Int = 1
    ): Observable<NowPlayingResponse>
}