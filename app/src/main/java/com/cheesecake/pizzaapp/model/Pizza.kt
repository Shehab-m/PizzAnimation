package com.cheesecake.pizzaapp.model

data class Pizza(
    val breadId: Int,
    val price: Int,
    val size: Float,
    val topping: MutableList<ToppingData>
    ){
    val totalPrice: Int
        get() = price + topping.sumOf { it.price }
}