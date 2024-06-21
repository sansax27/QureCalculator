package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.CalculatorHistoryRVAdapter
import com.example.myapplication.databinding.FragmentCalculatorHistoryBinding
import com.example.myapplication.viewmodel.CalculatorHistoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CalculatorHistoryFragment : Fragment() {


    private val binding: FragmentCalculatorHistoryBinding by lazy {
        FragmentCalculatorHistoryBinding.inflate(layoutInflater)
    }

    private val viewModel: CalculatorHistoryViewModel by viewModels()

    private val adapter = CalculatorHistoryRVAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCalHis.adapter = adapter
        binding.rvCalHis.layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        viewModel.viewModelScope.launch {
            viewModel.getCalculationData().collect{
                adapter.updateList(it)
            }
        }

    }


}