package com.cheesecake.pizzaapp.model

data class Pizza(
    val breadId: Int,
    val price: Int,
    val size: Float,
    val toppings: MutableList<Int>
    )