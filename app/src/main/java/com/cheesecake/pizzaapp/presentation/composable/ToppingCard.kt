package com.cheesecake.pizzaapp.presentation.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheesecake.pizzaapp.R
import com.cheesecake.pizzaapp.ui.theme.Green

@Composable
fun ToppingCard(image: Painter, modifier: Modifier = Modifier,onClick: ()->Unit,isSelected: Boolean) {
    val containerColor by animateColorAsState(
        targetValue = if (isSelected) Green else  Color.Transparent
    )

    Card(
        modifier = modifier.size(70.dp).clickable(
            interactionSource = CreateMutableInteractionSource(),
            indication = null,
            onClick = onClick
            ),
        colors = CardDefaults.cardColors(containerColor),
        shape = CircleShape,
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
    ToppingCard(painterResource(id = R.drawable.basil_3), onClick = {}, isSelected = true)
}