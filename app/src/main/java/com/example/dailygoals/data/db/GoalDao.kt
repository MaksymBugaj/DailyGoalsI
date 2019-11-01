package com.example.dailygoals.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dailygoals.data.db.entity.Goal

/*
* Created by Maksym Bugaj on 10/28/2019.
*/

@Dao
interface GoalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(goal: Goal)

    @Query("select * from goal_table")
    fun getAll(): LiveData<List<Goal>>
}