package com.cheesecake.pizzaapp.presentation.composable

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheesecake.pizzaapp.R
import com.cheesecake.pizzaapp.model.Pizza
import com.cheesecake.pizzaapp.model.ToppingData


@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalFoundationApi::class)
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
        val pizza by remember {
            mutableStateOf(pizzas[page])
        }
        val toppingsState = remember(pizza) { mutableStateOf(pizza.topping) }
        val toppingsScale by animateFloatAsState(targetValue = if(toppingsState.value.isEmpty())10f else .45f)
        Image(
            painter = painterResource(pizza.breadId),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 80.dp)
                .scale(.8f)
        )
        pizza.topping.forEach {
            AnimatedVisibility(
                visible = true, enter = fadeIn(), exit = ExitTransition.None,
                modifier = Modifier.scale(toppingsScale)
            ) {
                Image(painter = painterResource(id = it.imageId), contentDescription = "topping")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun HorizontalPizzaPagerPreview() {
    HorizontalPizzaPager(
        listOf(
            Pizza(
                R.drawable.bread_1, 17, 1f, mutableListOf(ToppingData(R.drawable.group_sussage, 5))
            )
        ), rememberPagerState()
    )
}

