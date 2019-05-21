package com.juniar.ancodev.infomovie.network

import com.juniar.ancodev.infomovie.data.NowPlayingResponse
import io.reactivex.Single

class NetworkRepository(private val networkService: NetworkService) : Repository {

    override fun getNowPlaying(): Single<NowPlayingResponse> {
        return networkService.getNowPlaying()
    }
}

