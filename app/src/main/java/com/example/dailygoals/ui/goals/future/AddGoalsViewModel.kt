package com.example.dailygoals.ui.goals.future

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dailygoals.R
import com.example.dailygoals.data.db.GoalDao
import com.example.dailygoals.data.db.entity.Goal
import com.example.dailygoals.util.ObservableString
import com.example.dailygoals.util.StringProvider
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class AddGoalsViewModel @Inject constructor(
    private val goalDao: GoalDao,
    private val stringProvider: StringProvider
) : ViewModel() {

    val title = ObservableField<String>()
    val description = ObservableString("")
    val errorTitle = ObservableString("")
    val errorDescription = ObservableString("")

    val clickedLiveData = MutableLiveData<String>()

    fun onButtonClicked() {
        val date = "2.10.2019"
        var isValid = true
        val titleString = title.get()!!
        if(titleString.isNullOrEmpty()){
            errorTitle.set(stringProvider.getString(R.string.title_cant_be_empty))
            Log.d("addGoals","title  " +title.get()!!)
            isValid=false
        }
        val descString = description.get()!!
        if(descString.isNullOrEmpty()){
            errorDescription.set(stringProvider.getString(R.string.description_cant_be_empty))
            Log.d("addGoals","desc: " + description.get()!!)
            isValid=false
        }
        if(isValid){
            val rnd = Random()
            val goal = Goal(
                rnd.nextInt(),
                titleString,
               descString,1,
                date
            )
            Log.d("addGoals","title and desc: " +title.get()!! + " : " + description.get()!!)
            insertGoals(goal)
        }
        clickedLiveData.value = "ADD"
    }

    fun insertGoals(goal: Goal) {
        Completable.fromCallable {
            goalDao.insert(goal)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {
                    Log.d("TAG", "completedInsert + ${goal.id}")

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    Log.e("insertSessionsError", e.message + " cause " + e.cause)
                }
            })

    }
}
