package com.example.learntogether

import org.junit.Test
import org.junit.Assert.assertEquals
import java.text.NumberFormat

class TipTimeTest {
    val tipTime = TipTime()

    @Test
    fun calculateTip_20PercentNoRoundUp(){
        val tipAmount = 10.00
        val tipPercentage = 20.00

        val result = tipTime.calculateTip(tipAmount, tipPercentage)
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        assertEquals(expectedTip, result)
    }
}