package com.cheesecake.pizzaapp.presentation

import com.cheesecake.pizzaapp.model.ToppingData

interface PizzaScreenInteractions {
    fun onClickTopping(position: Int,toppingData: ToppingData)
    fun onClickSize()
}