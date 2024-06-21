package com.example.myapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.dao.CalculationDataDao
import com.example.myapplication.data.model.CalculationDataDBModel


@Database(entities = [CalculationDataDBModel::class], version = 1)
abstract class CalculatorDatabase: RoomDatabase() {

    abstract fun getCalculationDataDao():CalculationDataDao
}