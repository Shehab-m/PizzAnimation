package com.cheesecake.pizzaapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheesecake.pizzaapp.R
import com.cheesecake.pizzaapp.ui.theme.Green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToppingCard(image:Painter, modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .size(70.dp),
        colors = CardDefaults.cardColors(Green),
        shape = CircleShape,
        onClick = {}
    ) {
        Box(modifier = Modifier.fillMaxSize())
        {
            Image(
                modifier = Modifier.align(Alignment.Center).padding(12.dp),
                painter = image, contentDescription = "topping",
            )
        }
    }
}

@Preview
@Composable
fun ToppingCardPreview() {
    ToppingCard(painterResource(id = R.drawable.basil_3))
}