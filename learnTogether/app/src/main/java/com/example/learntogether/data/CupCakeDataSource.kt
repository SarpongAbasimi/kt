package com.example.learntogether.data

import com.example.learntogether.R

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
}
