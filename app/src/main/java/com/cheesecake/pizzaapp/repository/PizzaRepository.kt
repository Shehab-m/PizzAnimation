package com.cheesecake.pizzaapp.repository

import com.cheesecake.pizzaapp.model.Pizza
import com.cheesecake.pizzaapp.model.Topping

interface PizzaRepository {
    fun getToppings(): List<Topping>
    fun getPizzas(): List<Pizza>
}