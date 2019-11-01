package com.example.dailygoals.util

import android.content.Context
import androidx.databinding.ObservableField

/*
* Created by Maksym Bugaj on 10/29/2019.
*/

interface StringProvider {
    fun getString(res: Int, vararg formatArgs: Any): String
}

class ContextStringProvider(private val context: Context) : StringProvider {
    @Suppress("SpreadOperator")
    override fun getString(res: Int, vararg formatArgs: Any): String {
        return context.getString(res, *formatArgs)
    }
}

typealias ObservableString = ObservableField<String>