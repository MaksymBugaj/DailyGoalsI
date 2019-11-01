package com.example.dailygoals.di

import com.example.dailygoals.ui.goals.current.CurrentGoalsFragment
import com.example.dailygoals.ui.goals.future.AddGoalsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
* Created by Maksym Bugaj on 10/28/2019.
*/

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAddGoalsFragment(): AddGoalsFragment

    @ContributesAndroidInjector
    abstract fun contributeCurrentGoalsFragment(): CurrentGoalsFragment
}