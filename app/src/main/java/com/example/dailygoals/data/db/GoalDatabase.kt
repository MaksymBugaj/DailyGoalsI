package com.example.dailygoals.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dailygoals.data.db.GoalDao
import com.example.dailygoals.data.db.entity.Goal

/*
* Created by Maksym Bugaj on 10/28/2019.
*/
@Database(
    entities = [
        Goal::class
    ],
    version = 2
)
abstract class GoalDatabase : RoomDatabase() {

    abstract fun goalDao(): GoalDao
}