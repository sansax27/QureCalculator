package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.CalculatorHistoryRepository
import com.example.myapplication.data.repository.CalculatorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CalculatorHistoryViewModel @Inject constructor(private val repository: CalculatorHistoryRepository): ViewModel() {


    fun getCalculationData() = repository.getCalculationData()


}