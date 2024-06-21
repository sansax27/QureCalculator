package com.example.myapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "CalculationData")
data class CalculationDataDBModel(@ColumnInfo(name="cal_str") val calString: String,@ColumnInfo(name = "cal_res") val calResult:String,
                                  @PrimaryKey @ColumnInfo(name = "cal_timestamp")val timestamp:Long)
