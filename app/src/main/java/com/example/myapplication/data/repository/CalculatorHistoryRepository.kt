package com.example.myapplication.data.repository

import com.example.myapplication.data.dao.CalculationDataDao
import javax.inject.Inject

class CalculatorHistoryRepository @Inject constructor(private val calculationDataDao: CalculationDataDao) {


    fun getCalculationData() = calculationDataDao.getCalculationData()

}