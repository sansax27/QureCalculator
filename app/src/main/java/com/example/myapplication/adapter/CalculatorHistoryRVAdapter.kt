package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.CalculationDataDBModel
import com.example.myapplication.databinding.LayoutCalculationHisBinding
import java.text.SimpleDateFormat
import java.util.Locale

class CalculatorHistoryRVAdapter: RecyclerView.Adapter<CalculatorHistoryRVAdapter.CalculatorHistoryRVViewHolder>() {

    inner class CalculatorHistoryRVViewHolder(private val binding: LayoutCalculationHisBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(calculationDataDBModel: CalculationDataDBModel) {
                binding.tvCalHisCalcNum.text = calculationDataDBModel.calString
                binding.tvCalHisCalcRs.text = calculationDataDBModel.calResult
                binding.tvCalHisDate.text = simpleDateFormat.format(calculationDataDBModel.timestamp)
            }
        }

    private val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)

    private val dataList = mutableListOf<CalculationDataDBModel>()

    fun updateList(list: List<CalculationDataDBModel>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalculatorHistoryRVViewHolder {
        return CalculatorHistoryRVViewHolder(LayoutCalculationHisBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CalculatorHistoryRVViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}