package com.juniar.ancodev.infomovie.di

import android.app.Application
import com.juniar.ancodev.infomovie.MainApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import juniar.common.androidx.modules.CommonModule
import juniar.common.androidx.modules.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBuilder::class, FragmentBuilder::class, AppModule::class, CommonModule::class])
interface AppComponent : AndroidInjector<MainApp> {
    fun inject(instance: DaggerApplication)
    override fun inject(application: MainApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder
        fun commonModule(commonModule: CommonModule): Builder
        fun build(): AppComponent
    }
}