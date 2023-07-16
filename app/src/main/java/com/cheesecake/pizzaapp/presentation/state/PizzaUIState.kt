package com.cheesecake.pizzaapp.presentation.state

import com.cheesecake.pizzaapp.model.Pizza
import com.cheesecake.pizzaapp.model.Topping

data class PizzaUIState(
    val toppings: List<Topping> = emptyList(),
    val pizzas: MutableList<Pizza> = mutableListOf()
)