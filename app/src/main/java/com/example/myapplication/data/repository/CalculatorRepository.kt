package com.example.myapplication.data.repository

import com.example.myapplication.data.dao.CalculationDataDao
import com.example.myapplication.data.model.CalculationDataDBModel
import javax.inject.Inject

class CalculatorRepository @Inject constructor(private val calculationDataDao: CalculationDataDao) {

    suspend fun saveCalculationData(calculationDataDBModel: CalculationDataDBModel) =
        calculationDataDao.insertCalculationData(calculationDataDBModel)
}