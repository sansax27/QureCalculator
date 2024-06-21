package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.CalculationDataDBModel
import com.example.myapplication.data.repository.CalculatorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(private val repository: CalculatorRepository): ViewModel() {

    fun saveCalculationData(calculationDataDBModel: CalculationDataDBModel) = viewModelScope.launch {
        repository.saveCalculationData(calculationDataDBModel)
    }

}