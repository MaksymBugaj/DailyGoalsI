package com.example.dailygoals.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dailygoals.ui.goals.current.CurrentGoalsViewModel
import com.example.dailygoals.ui.goals.future.AddGoalsViewModel
import com.example.dailygoals.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/*
* Created by Maksym Bugaj on 10/28/2019.
*/
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddGoalsViewModel::class)
    abstract fun bindAddGoalsViewModel(addGoalsViewModel: AddGoalsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CurrentGoalsViewModel::class)
    abstract fun bindCurrentGoalsViewModel(currentGoalsViewModel: CurrentGoalsViewModel): ViewModel



    //instance of viewmodelproviderfactory
    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}