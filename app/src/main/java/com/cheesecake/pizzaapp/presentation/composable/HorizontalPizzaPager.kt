package com.cheesecake.pizzaapp.presentation.composable

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheesecake.pizzaapp.model.Pizza
import com.cheesecake.pizzaapp.model.PizzaSize

@SuppressLint("MutableCollectionMutableState", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun HorizontalPizzaPager(
    pizzas: List<Pizza>,
    pagerState: PagerState,
    pagerModifier: Modifier = Modifier
) {
    HorizontalPager(
        modifier = pagerModifier.fillMaxWidth(),
        state = pagerState,
        pageCount = pizzas.size,
    ) { page ->
        val pizzaScale by animateFloatAsState(targetValue = when(pizzas[page].size){
            PizzaSize.LARGE -> 1f
            PizzaSize.MEDIUM -> .8f
            PizzaSize.SMALL -> .6f
        })
        val toppingScale by animateFloatAsState(targetValue = when(pizzas[page].size){
            PizzaSize.LARGE -> .6f
            PizzaSize.MEDIUM -> .6f
            PizzaSize.SMALL -> .5f
        })
        Image(
            painter = painterResource(pizzas[page].breadId),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 80.dp).scale(pizzaScale)
        )
        pizzas[page].toppings.forEach {
            AnimatedVisibility(
                visible = it.isSelected ,
                enter = fadeIn() + scaleIn(initialScale = 5f),
                exit = ExitTransition.None,
                modifier = Modifier.scale(toppingScale),
            ) {
                Image(
                    painter = painterResource(id = it.imageGroupId),
                    contentDescription = "topping",
                    modifier = Modifier.scale(pizzaScale)
                )
            }
        }
    }

}


@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun HorizontalPizzaPagerPreview() {

}

