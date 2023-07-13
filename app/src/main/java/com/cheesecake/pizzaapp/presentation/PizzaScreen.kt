package com.cheesecake.pizzaapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cheesecake.pizzaapp.R
import com.cheesecake.pizzaapp.presentation.composable.PizzaSizeCard
import com.cheesecake.pizzaapp.presentation.composable.PizzaViewModel
import com.cheesecake.pizzaapp.presentation.composable.ToppingCard
import com.cheesecake.pizzaapp.ui.theme.Grey
import com.cheesecake.pizzaapp.ui.theme.Marron
import com.cheesecake.pizzaapp.ui.theme.Typography
import com.cheesecake.pizzaapp.ui.theme.White

@Composable
fun PizzaScreen(
    viewModel: PizzaViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    PizzaScreenContent(state)
}

@Composable
fun PizzaScreenContent(state: PizzaUIState) {
    Column(
        Modifier
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_svgrepo_com),
                contentDescription = "back button"
            )

            Text(text = "Pizza", style = Typography.bodyMedium)

            Icon(
                painter = painterResource(id = R.drawable.heart_fill),
                contentDescription = "favourite"
            )
        }

        Image(
            painter = painterResource(id = R.drawable.plate), contentDescription = "plate",
            modifier = Modifier.padding(horizontal = 60.dp)
        )

        Text(text = "$17", style = Typography.bodyLarge, modifier = Modifier.padding(top = 30.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            PizzaSizeCard(text = "S")
            PizzaSizeCard(text = "M", modifier = Modifier.padding(horizontal = 16.dp))
            PizzaSizeCard(text = "L")
        }

        Text(
            text = "CUSTOMIZE YOUR PIZZA", style = Typography.labelSmall, color = Grey,
            modifier = Modifier
                .padding(top = 50.dp, start = 20.dp)
                .fillMaxWidth()
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.toppings) {
                ToppingCard(image = painterResource(id = it))
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


@Preview
@Composable
fun PizzaScreenPreview() {
    PizzaScreen()
}