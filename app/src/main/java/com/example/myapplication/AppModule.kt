package com.example.myapplication

import android.content.Context
import androidx.room.PrimaryKey
import androidx.room.Room
import com.example.myapplication.data.database.CalculatorDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun providesCalculatorDatabase(@ApplicationContext context: Context)
    = Room.databaseBuilder(context, CalculatorDatabase::class.java, "calculator_db").build()

    @Singleton
    @Provides
    fun providesCalculationDataDao(calculatorDatabase: CalculatorDatabase) = calculatorDatabase.getCalculationDataDao()

}