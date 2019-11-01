package com.example.dailygoals.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.dailygoals.data.db.GoalDao
import com.example.dailygoals.data.db.GoalDatabase
import com.example.dailygoals.util.ContextStringProvider
import com.example.dailygoals.util.StringProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
* Created by Maksym Bugaj on 10/28/2019.
*/
@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): GoalDatabase {
        return Room
            .databaseBuilder(app as Context, GoalDatabase::class.java, "agenda.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideScheduleDao(db: GoalDatabase): GoalDao {
        return db.goalDao()
    }

    @Singleton
    @Provides
    fun provideStringProvider(app: Application): StringProvider {
        return ContextStringProvider(app.applicationContext)
    }
}