package com.cheesecake.pizzaapp.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheesecake.pizzaapp.ui.theme.Typography
import com.cheesecake.pizzaapp.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaSizeCard(text: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .size(45.dp),
        colors = CardDefaults.cardColors(White),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(1.dp),
        onClick = {}
    ) {
        Box(modifier = Modifier.fillMaxSize())
        {
            Text(
                text = text,
                style = Typography.bodySmall,
                modifier = modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun CircleCardPreview() {
    PizzaSizeCard("M")
}