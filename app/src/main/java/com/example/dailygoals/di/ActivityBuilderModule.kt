package com.example.dailygoals.di

import com.example.dailygoals.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
* Created by Maksym Bugaj on 10/28/2019.
*/

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity() : MainActivity


}