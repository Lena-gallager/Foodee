package com.example.petproject1.ui.screen.cart.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.petproject1.data.OrderDetailsState
import com.example.petproject1.ui.components.OrderCounterComponent
import com.example.petproject1.ui.theme.AppTheme

@Composable
fun OrderDetailsSection(
    modifier: Modifier = Modifier,
    state: List<OrderDetailsState>,
    onAddItemClick: () -> Unit,
    onRemoveItemClick: () -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        SectionHeader()
        Spacer(modifier = Modifier.height(16.dp))
        state.onEach { item ->
            OrderItem(
                state = item,
                onAddItemClick = onAddItemClick,
                onRemoveItemClick = onRemoveItemClick,
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun SectionHeader(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Order",
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colors.onBackground,
        )
        Text(
            text = "Clear All",
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colors.onActionSurface,
        )
    }
}

@Composable
private fun OrderItem(
    modifier: Modifier = Modifier,
    state: OrderDetailsState,
    onAddItemClick: () -> Unit,
    onRemoveItemClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .shadow(
                elevation = 10.dp,
                spotColor = AppTheme.colors.actionSurface,
                shape = RoundedCornerShape(28.dp),
            )
            .background(
                shape = RoundedCornerShape(28.dp),
                color = AppTheme.colors.surface,
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .weight(1f)
                    .padding(18.dp),
                painter = painterResource(state.productData.productImg),
                contentDescription = null,
            )
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = state.productData.headline,
                    style = AppTheme.typography.bodySmall,
                    color = AppTheme.colors.onRegularSurface,
                )
                Text(
                    text = state.orderState.totalPrice,
                    style = AppTheme.typography.bodySmall,
                    color = AppTheme.colors.onActionSurface,
                )
            }
            OrderCounterComponent(
                modifier = Modifier.weight(1f),
                amount = state.orderState.amount,
                onAddItemClick = onAddItemClick,
                onRemoveItemClick = onRemoveItemClick,
            )
        }
    }
}
