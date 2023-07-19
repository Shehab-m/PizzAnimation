package com.cheesecake.pizzaapp.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cheesecake.pizzaapp.R
import com.cheesecake.pizzaapp.ui.theme.Typography

@Composable
fun HeaderPizzaScreen(onClickBack: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 40.dp, horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onClickBack) {
            Icon(
                painter = painterResource(id = R.drawable.back_svgrepo_com),
                contentDescription = "back button"
            )
        }
        Text(text = "Pizza", style = Typography.bodyMedium)
        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.heart_fill),
                contentDescription = "favourite"
            )
        }

    }
}
