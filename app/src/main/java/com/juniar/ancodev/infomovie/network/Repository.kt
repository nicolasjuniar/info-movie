package com.juniar.ancodev.infomovie.network

import com.juniar.ancodev.infomovie.data.NowPlayingResponse
import io.reactivex.Single

interface Repository {
    fun getNowPlaying(): Single<NowPlayingResponse>
}