package com.example.petproject1.ui.screen.cart.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject1.data.OrderData
import com.example.petproject1.data.OrderState
import com.example.petproject1.ui.theme.AppTheme

@Composable
fun CartActionBar(
    modifier: Modifier = Modifier,
    orderState: OrderState,
    onClicked: () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        color = AppTheme.colors.surface,
        contentColor = AppTheme.colors.onSurface,
        shadowElevation = 16.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .height(76.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Cart(
                totalPrice = orderState.totalPrice,
                onClicked = onClicked,
                modifier = Modifier.weight(weight = 1f),
            )
        }
    }
}

@Composable
private fun Cart(
    modifier: Modifier = Modifier,
    totalPrice: String,
    onClicked: () -> Unit,
) {
    Surface(
        modifier = modifier.clickable(onClick = onClicked),
        color = AppTheme.colors.secondarySurface,
        contentColor = AppTheme.colors.onSecondarySurface,
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    text = "Next step",
                    style = AppTheme.typography.titleSmall,
                )
                Text(
                    text = totalPrice,
                    style = AppTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CartScreenPreview() {
    CartActionBar(
        orderState = OrderData,
        onClicked = {},
    )
}
