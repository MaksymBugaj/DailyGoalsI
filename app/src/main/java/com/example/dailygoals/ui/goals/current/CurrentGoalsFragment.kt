package com.example.dailygoals.ui.goals.current

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.dailygoals.ui.MultipleItemsAdapter
import com.example.dailygoals.ui.SwipeController
import com.example.dailygoals.viewmodel.ViewModelProviderFactory
import com.example.dailygoals.databinding.CurrentGoalsFragmentBinding

import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.current_goals_fragment.*
import javax.inject.Inject

class CurrentGoalsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory


    private val viewModel: CurrentGoalsViewModel by viewModels {
        viewModelProviderFactory
    }

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return CurrentGoalsFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            this.vm = viewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val swipeController = SwipeController()
        val itemTouchHelper = ItemTouchHelper(swipeController)
        recyclerView = recycler_view
        recyclerView.adapter = MultipleItemsAdapter()
//        itemTouchHelper.attachToRecyclerView(recyclerView)


        getGoalsFromDb()
    }

    private fun getGoalsFromDb() {
        viewModel.getAllGoalsLiveData().observe(this,
            Observer {
                if (it.isNotEmpty()) {
                    Log.d("addGoals", "smt added: " + it.size)
                    (recyclerView.adapter as MultipleItemsAdapter).setGoals(it)
                }
            })
    }

}
