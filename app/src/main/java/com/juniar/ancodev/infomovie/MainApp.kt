package com.juniar.ancodev.infomovie

import com.juniar.ancodev.infomovie.BuildConfig.BASE_URL
import com.juniar.ancodev.infomovie.di.AppComponent
import com.juniar.ancodev.infomovie.di.DaggerAppComponent
import com.juniar.ancodev.infomovie.di.HeaderInterceptor
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import juniar.common.androidx.modules.CommonModule
import juniar.common.androidx.modules.NetworkModule

class MainApp : DaggerApplication() {
    lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent
            .builder()
            .create(this)
            .networkModule(NetworkModule(BASE_URL, HeaderInterceptor()))
            .commonModule(CommonModule(this))
            .build()
        appComponent.inject(this)
        return appComponent
    }

}