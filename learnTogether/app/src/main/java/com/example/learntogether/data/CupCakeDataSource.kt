package com.example.learntogether.data

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import com.example.learntogether.R
import java.util.Locale

object CupCakeDataSource {
    val cupCakeQuantityOptions: List<Pair<Int, Int>> = listOf(
        Pair(R.string.one_cupcake, 1),
        Pair(R.string.six_cupcakes,6),
        Pair(R.string.twelve_cupcakes, 12)
    )

    val cupCakeFlavourOptions: List<String> = listOf(
        "Rice and Chicken",
        "Kenkey and Fish",
        "Banku", "Gob3"
    )

    fun generateCalenderDates(): MutableList<String>{
        val calender = Calendar.getInstance()
        val formatter = SimpleDateFormat("EEE, MMM d", Locale.getDefault())
        val mutableList: MutableList<String> = mutableListOf()

        repeat(4){
             mutableList.add(formatter.format(calender.time))
            calender.add(Calendar.DATE, 1)
        }

        return mutableList
    }
}
