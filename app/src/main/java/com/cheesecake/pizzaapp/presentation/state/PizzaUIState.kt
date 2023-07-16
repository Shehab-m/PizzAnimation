package com.cheesecake.pizzaapp.presentation.state

import com.cheesecake.pizzaapp.model.Pizza

data class PizzaUIState(
    val toppings: List<Int> = emptyList(),
    val pizzas: List<Pizza> = emptyList()
)