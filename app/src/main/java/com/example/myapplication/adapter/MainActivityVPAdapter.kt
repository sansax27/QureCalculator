package com.example.myapplication.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ui.CalculatorFragment
import com.example.myapplication.ui.CalculatorHistoryFragment
import com.example.myapplication.ui.MainActivity

class MainActivityVPAdapter(activity: MainActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position==0) {
            CalculatorFragment()
        } else {
            CalculatorHistoryFragment()
        }
    }
}