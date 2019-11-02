package com.example.dailygoals.ui.goals.future

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.dailygoals.R

import com.example.dailygoals.viewmodel.ViewModelProviderFactory
import com.example.dailygoals.databinding.AddGoalsFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AddGoalsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory


    private val viewModel: AddGoalsViewModel by viewModels {
        viewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = AddGoalsFragmentBinding.inflate(inflater,container,false).apply {
            this.lifecycleOwner = viewLifecycleOwner
            this.vm = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.clickedLiveData.observe(this, Observer {
            when(it){
                //todo hide keyboard
                "ADD" -> findNavController().navigate(R.id.currentGoalsFragment)
            }
        })
    }
}
