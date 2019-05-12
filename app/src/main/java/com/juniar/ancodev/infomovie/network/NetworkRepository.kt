package com.juniar.ancodev.infomovie.network

import com.juniar.ancodev.infomovie.data.NowPlayingResponse
import io.reactivex.Observable
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val networkService: NetworkService) : Repository {

    override fun getNowPlaying(): Observable<NowPlayingResponse> {
        return networkService.getNowPlaying()
    }
}