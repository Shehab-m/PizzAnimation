package com.cheesecake.pizzaapp.presentation.state

enum class CardToppingState {
    SELECTED, NOT_SELECTED;
}

fun CardToppingState.nextState(): CardToppingState {
    return when(this) {
        CardToppingState.NOT_SELECTED -> CardToppingState.SELECTED
        CardToppingState.SELECTED -> CardToppingState.NOT_SELECTED
    }
}