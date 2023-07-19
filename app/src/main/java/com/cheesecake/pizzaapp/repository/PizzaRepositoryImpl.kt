package com.cheesecake.pizzaapp.repository

import com.cheesecake.pizzaapp.R
import com.cheesecake.pizzaapp.model.Pizza
import com.cheesecake.pizzaapp.model.PizzaSize
import com.cheesecake.pizzaapp.model.Topping
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor() : PizzaRepository {

    override fun getToppings(): List<Topping> {
        return listOf(
            Topping(R.drawable.basil_3, R.drawable.group_basil, 2, false),
            Topping(R.drawable.onion_3, R.drawable.group_basil, 3, false),
            Topping(R.drawable.broccoli_3, R.drawable.group_basil, 4, false),
            Topping(R.drawable.mushroom_3, R.drawable.group_basil, 3, false),
            Topping(R.drawable.sausage_3, R.drawable.group_sussage, 5, false),
        )
    }

    override fun getPizzas(): List<Pizza> {
        return listOf(
            Pizza(
                R.drawable.bread_1, 17, PizzaSize.MEDIUM, getToppings()
            ),
            Pizza(
                R.drawable.bread_2, 21, PizzaSize.MEDIUM, getToppings()
            ),
            Pizza(
                R.drawable.bread_3, 19, PizzaSize.MEDIUM, getToppings()
            ),
            Pizza(
                R.drawable.bread_4, 12, PizzaSize.MEDIUM, getToppings()
            ),
            Pizza(
                R.drawable.bread_5, 24, PizzaSize.MEDIUM, getToppings()
            ),
            )
    }


}