package com.juniar.ancodev.infomovie.network

import com.juniar.ancodev.infomovie.data.NowPlayingResponse
import io.reactivex.Observable

interface Repository {
    fun getNowPlaying(): Observable<NowPlayingResponse>
}