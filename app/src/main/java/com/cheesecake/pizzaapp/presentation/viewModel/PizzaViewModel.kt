package com.cheesecake.pizzaapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.cheesecake.pizzaapp.model.PizzaSize
import com.cheesecake.pizzaapp.presentation.state.PizzaUIState
import com.cheesecake.pizzaapp.repository.PizzaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor(private val repository: PizzaRepository) : ViewModel(),
    PizzaScreenInteractions {

    private val _state = MutableStateFlow(PizzaUIState())
    val state = _state.asStateFlow()

    init {
        initData()
    }

    private fun initData() {
        _state.update {
            it.copy(
                pizzas = repository.getPizzas()
            )
        }
    }

    override fun onClickTopping(toppingIndex: Int, position: Int) {
        _state.update {
            val pizza = it.pizzas[position]
            val toppings = pizza.toppings.toMutableList()
            val topping = toppings[toppingIndex]
            toppings[toppingIndex] = topping.copy(
                isSelected = !(topping.isSelected)
            )
            val updatedPizzas = it.pizzas.toMutableList()
            updatedPizzas[position] = pizza.copy(
                toppings = toppings
            )
            it.copy(pizzas = updatedPizzas)
        }
    }


    override fun onClickSize(position: Int, size: PizzaSize) {
        _state.update {
            val pizza = it.pizzas[position]
            val updatedPizzas = it.pizzas.toMutableList()
            updatedPizzas[position] = pizza.copy(
                size = size
            )
            it.copy(pizzas = updatedPizzas)
        }
    }

    override fun onClickBack() {
        _state.update {
            val pizzas = it.pizzas.toMutableList()
            val p = pizzas.map { pizza ->
                pizza.copy(
                    size = PizzaSize.MEDIUM,
                    toppings = pizza.toppings.map {
                        it.copy(
                            isSelected = false
                        )
                    }
                )
            }
            it.copy(pizzas = p)
        }
    }

//    override fun onClickBack() {
//        _state.update {
//            val o = it.pizzas.map { pizza ->
//                pizza.copy(
//                    toppings = pizza.toppings.map {
//                        it.copy(
//                            isSelected = false
//                        )
//                    }
//                )
//            }
//
//            it.copy(pizzas = o)
//
//
//        }
//        Log.i("onClickBack: ",_state.value.toString())
//    }

}