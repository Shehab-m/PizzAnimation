package com.cheesecake.pizzaapp.presentation.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheesecake.pizzaapp.model.PizzaSize
import com.cheesecake.pizzaapp.ui.theme.White

@Composable
fun RowPizzaSizes(
    size: PizzaSize,
    onClickSize: (PizzaSize) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        val backgroundPosition by animateDpAsState(
            targetValue = when (size) {
                PizzaSize.SMALL -> 0.dp
                PizzaSize.MEDIUM -> 66.dp
                PizzaSize.LARGE -> 121.dp
            }, animationSpec = tween(500)
        )
        Card(
            modifier = Modifier.offset(x = backgroundPosition).size(45.dp),
            colors = CardDefaults.cardColors(White),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(2.dp)
        ) {}
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            PizzaSizeCard(
                text = "S",
                onClick = { onClickSize(PizzaSize.SMALL) }
            )
            PizzaSizeCard(
                text = "M",
                modifier = Modifier.padding(horizontal = 16.dp),
                onClick = { onClickSize(PizzaSize.MEDIUM) })
            PizzaSizeCard(
                text = "L",
                onClick = { onClickSize(PizzaSize.LARGE) })
        }
    }

}

@Preview
@Composable
fun RowPizzaSizesPreview() {
    RowPizzaSizes(PizzaSize.LARGE, {})
}