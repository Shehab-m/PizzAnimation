package com.cheesecake.pizzaapp.presentation.state

data class PizzaUIState(
    val toppings: List<Int> = emptyList(),
    val bread: List<Int> = emptyList()
)