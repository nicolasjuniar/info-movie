package com.juniar.ancodev.infomovie.di

import android.annotation.SuppressLint
import com.juniar.ancodev.infomovie.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@SuppressLint("unused")
@Module
abstract class ActivityBuilder {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}