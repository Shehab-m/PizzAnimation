package com.cheesecake.pizzaapp.model

data class Topping(
    val imageMainId: Int,
    val imageGroupId: Int,
    val price: Int,
    var isSelected: Boolean = false,
)