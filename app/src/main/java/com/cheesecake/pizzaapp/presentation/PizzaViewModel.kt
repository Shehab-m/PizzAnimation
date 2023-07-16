package com.cheesecake.pizzaapp.presentation

import androidx.lifecycle.ViewModel
import com.cheesecake.pizzaapp.R
import com.cheesecake.pizzaapp.model.Pizza
import com.cheesecake.pizzaapp.presentation.state.PizzaUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(PizzaUIState())
    val state = _state.asStateFlow()

    init {
        initData()
    }

    private fun initData() {
        _state.update {
            it.copy(
                toppings = listOf(
                    R.drawable.basil_3,
                    R.drawable.onion_3,
                    R.drawable.broccoli_3,
                    R.drawable.mushroom_3,
                    R.drawable.sausage_3,
                ),
                pizzas = listOf(
                    Pizza(
                        R.drawable.bread_1, 17, 1f, mutableListOf()
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
            )
        }
    }

}