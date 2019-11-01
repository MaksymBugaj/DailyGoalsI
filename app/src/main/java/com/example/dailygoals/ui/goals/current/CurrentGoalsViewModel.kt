package com.example.dailygoals.ui.goals.current

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dailygoals.data.db.GoalDao
import com.example.dailygoals.data.db.entity.Goal
import javax.inject.Inject

class CurrentGoalsViewModel @Inject constructor(
    private val goalDao: GoalDao
) : ViewModel() {





//    val getAllGoals



    fun getAllGoalsLiveData(): LiveData<List<Goal>> {
        return goalDao.getAll()
    }
}
