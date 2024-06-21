package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.data.model.CalculationDataDBModel
import com.example.myapplication.databinding.FragmentCalculatorBinding
import com.example.myapplication.viewmodel.CalculatorViewModel
import com.notkamui.keval.Keval
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.Date


@AndroidEntryPoint
class CalculatorFragment : Fragment() {


    private val binding: FragmentCalculatorBinding by lazy {
        FragmentCalculatorBinding.inflate(layoutInflater)
    }

    private val calculatorViewModel:CalculatorViewModel by viewModels()

    private var calculationString = StringBuilder("")
    private val calOpsList = mutableListOf("+","-","/","*")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calUIChildCount = binding.glCalUi.childCount
        for(itemIdx in 0..<calUIChildCount) {
            val childView = binding.glCalUi.getChildAt(itemIdx)
            childView.setOnClickListener {
                Timber.i("Child View ${childView.tag}")

                if (calOpsList.contains(childView.tag.toString())) {
                    Timber.i("Here")
                    if (calculationString.isEmpty() || calculationString.last().toString() in calOpsList) {
                        Toast.makeText(
                            context,
                            resources.getText(R.string.cal_screen_enter_num_bef_op),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        calculationString.append(childView.tag)
                    }

                } else if (childView.tag.toString().toIntOrNull() != null) {
                    calculationString.append(childView.tag)
                } else {
                    if (childView.tag.toString() == "bs") {
                        calculationString.deleteCharAt(calculationString.lastIndex)
                    } else {
                        val result = Keval.eval(calculationString.toString())
                        if (result - result.toInt() > 0) {
                            binding.tvCalResultsDisplay.text = result.toString()
                        } else {
                            binding.tvCalResultsDisplay.text = result.toInt().toString()
                        }
                        calculatorViewModel.saveCalculationData(
                            CalculationDataDBModel(calculationString.toString(), result.toString(), Date().time))

                    }
                }
                Timber.i("Calculation String $calculationString")
                binding.tvCalNumDisplay.text = calculationString
            }
        }
    }

}