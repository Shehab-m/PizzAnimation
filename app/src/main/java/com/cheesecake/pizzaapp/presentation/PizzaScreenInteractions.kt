package com.cheesecake.pizzaapp.presentation

import com.cheesecake.pizzaapp.model.PizzaSize

interface PizzaScreenInteractions {
    fun onClickTopping(toppingIndex: Int,position: Int)
    fun onClickSize(position: Int,size: PizzaSize)
    fun onClickBack()
}