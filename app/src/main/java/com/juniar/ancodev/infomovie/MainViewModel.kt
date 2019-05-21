package com.juniar.ancodev.infomovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.juniar.ancodev.infomovie.data.MovieModel
import com.juniar.ancodev.infomovie.network.NetworkRepository
import juniar.common.androidx.base.BaseViewModel
import juniar.common.androidx.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class MainViewModel @Inject constructor(private val networkRepository: NetworkRepository) : BaseViewModel() {

    private val listNowPlaying = MutableLiveData<List<MovieModel>?>()

    fun observeNowPlaying(): LiveData<List<MovieModel>?> = listNowPlaying

    private val isLoadingNowPlayingMovie = MutableLiveData<Boolean>()

    fun observeLoadingNowPlayingMovie(): LiveData<Boolean> = isLoadingNowPlayingMovie

    init {
        listNowPlaying.value = listOf()
    }

    fun getNowPlaying() {
        isLoadingNowPlayingMovie.postValue(true)
        networkRepository.getNowPlaying().onResult({
            listNowPlaying.postValue(it.results)
            isLoadingNowPlayingMovie.postValue(false)
        }, {
            isError.postValue(it)
            isLoadingNowPlayingMovie.postValue(false)
        })
    }
}