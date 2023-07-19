package com.cheesecake.pizzaapp.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cheesecake.pizzaapp.R
import com.cheesecake.pizzaapp.model.PizzaSize
import com.cheesecake.pizzaapp.presentation.composable.HeaderPizzaScreen
import com.cheesecake.pizzaapp.presentation.composable.HorizontalPizzaPager
import com.cheesecake.pizzaapp.presentation.composable.PizzaSizeCard
import com.cheesecake.pizzaapp.presentation.composable.RowPizzaSizes
import com.cheesecake.pizzaapp.presentation.composable.ToppingCard
import com.cheesecake.pizzaapp.presentation.state.PizzaUIState
import com.cheesecake.pizzaapp.repository.PizzaRepositoryImpl
import com.cheesecake.pizzaapp.ui.theme.Grey
import com.cheesecake.pizzaapp.ui.theme.Marron
import com.cheesecake.pizzaapp.ui.theme.Typography
import com.cheesecake.pizzaapp.ui.theme.White

@Composable
fun PizzaScreen(
    viewModel: PizzaViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    PizzaScreenContent(state, viewModel)
}

@SuppressLint(
    "UnrememberedMutableState", "MutableCollectionMutableState",
    "UnusedMaterial3ScaffoldPaddingParameter"
)
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PizzaScreenContent(
    state: PizzaUIState,
    listener: PizzaScreenInteractions
) {
    val pagerState = rememberPagerState(initialPage = 0)

    Scaffold(topBar = { HeaderPizzaScreen(listener::onClickBack) })
    { padding ->

        Column(
            Modifier.fillMaxSize().background(White).padding(top = padding.calculateTopPadding()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(.4f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plate),
                    contentDescription = "plate",
                    modifier = Modifier.padding(horizontal = 60.dp).align(Alignment.Center)
                )
                HorizontalPizzaPager(
                    state.pizzas,
                    pagerState,
                    Modifier.align(Alignment.Center)
                )
            }
            Text(
                text = "$${state.pizzas[pagerState.currentPage].totalPrice}",
                style = Typography.bodyLarge, modifier = Modifier.padding(top = 30.dp)
            )
            RowPizzaSizes(
                size = state.pizzas[pagerState.currentPage].size,
                onClickSize = { size -> listener.onClickSize(pagerState.currentPage, size) },
                modifier = Modifier.padding(top = 30.dp)
            )
            Text(
                text = "CUSTOMIZE YOUR PIZZA", style = Typography.labelSmall, color = Grey,
                modifier = Modifier.padding(top = 50.dp, start = 20.dp).fillMaxWidth()
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(state.pizzas[pagerState.currentPage].toppings) { toppingIndex, topping ->
                    ToppingCard(
                        onClick = { listener.onClickTopping(toppingIndex, pagerState.currentPage) },
                        isSelected = topping.isSelected,
                        image = painterResource(id = topping.imageMainId)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(modifier = Modifier
                .padding(bottom = 40.dp)
                .clip(RoundedCornerShape(4.dp)),
                colors = ButtonDefaults.buttonColors(Marron), onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.buy),
                    contentDescription = "buy",
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = "Add to cart",
                    style = Typography.bodySmall,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun PizzaScreenPreview() {
    PizzaScreen(PizzaViewModel(PizzaRepositoryImpl()))
}