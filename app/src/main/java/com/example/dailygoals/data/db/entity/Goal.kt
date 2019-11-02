package com.example.dailygoals.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Created by Maksym Bugaj on 10/28/2019.
*/

@Entity(tableName = "goal_table")
class Goal(
    @PrimaryKey(autoGenerate = true)
    var id: Int ,
    var name: String = "",
    var description:String = "",
    var priority: Int = 1,
    var date: String,
    var isExpanded:Boolean = false
)