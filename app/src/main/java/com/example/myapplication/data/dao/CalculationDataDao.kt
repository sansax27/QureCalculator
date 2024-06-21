package com.example.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.model.CalculationDataDBModel
import kotlinx.coroutines.flow.Flow


@Dao
interface CalculationDataDao {

    @Query("select * from CalculationData order by cal_timestamp")
    fun getCalculationData() : Flow<List<CalculationDataDBModel>>

    @Insert
    suspend fun insertCalculationData(calculationDataDBModel: CalculationDataDBModel)

}