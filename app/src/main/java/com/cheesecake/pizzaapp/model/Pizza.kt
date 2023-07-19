package com.cheesecake.pizzaapp.model

data class Pizza(
    val breadId: Int,
    val price: Int,
    var size: PizzaSize,
    val toppings: List<Topping>
) {
    val totalPrice: Int
        get() = price + toppings.filter { it.isSelected }.sumOf { it.price } + size.price
}
