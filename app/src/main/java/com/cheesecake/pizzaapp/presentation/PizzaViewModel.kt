package com.cheesecake.pizzaapp.presentation

import androidx.lifecycle.ViewModel
import com.cheesecake.pizzaapp.presentation.state.PizzaUIState
import com.cheesecake.pizzaapp.repository.PizzaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor(private val repository: PizzaRepository) : ViewModel() {

    private val _state = MutableStateFlow(PizzaUIState())
    val state = _state.asStateFlow()

    init {
        initData()
    }

    private fun initData() {
        _state.update {
            it.copy(
                toppings = repository.getToppings(),
                pizzas = repository.getPizzas()
            )
        }
    }

}