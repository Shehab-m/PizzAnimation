package com.cheesecake.pizzaapp.repository

import com.cheesecake.pizzaapp.R
import com.cheesecake.pizzaapp.model.Pizza
import com.cheesecake.pizzaapp.model.Topping
import com.cheesecake.pizzaapp.model.ToppingData
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor() : PizzaRepository {

    override fun getToppings(): List<Topping> {
        return listOf(
            Topping(R.drawable.basil_3, ToppingData(R.drawable.group_basil, 8)),
            Topping(R.drawable.onion_3, ToppingData(R.drawable.group_basil, 8)),
            Topping(R.drawable.broccoli_3, ToppingData(R.drawable.group_basil, 8)),
            Topping(R.drawable.mushroom_3, ToppingData(R.drawable.group_basil, 8)),
            Topping(R.drawable.sausage_3, ToppingData(R.drawable.group_sussage, 8)),
        )
    }

    override fun getPizzas(): List<Pizza> {
        return listOf(
            Pizza(
                R.drawable.bread_1, 17, 1f,mutableListOf()
            ),
            Pizza(
                R.drawable.bread_2, 21, 1f, mutableListOf()
            ),
            Pizza(
                R.drawable.bread_3, 19, 1f, mutableListOf()
            ),
            Pizza(
                R.drawable.bread_4, 12, 1f, mutableListOf()
            ),
            Pizza(
                R.drawable.bread_5, 24, 1f, mutableListOf()
            ),

            )
    }


}