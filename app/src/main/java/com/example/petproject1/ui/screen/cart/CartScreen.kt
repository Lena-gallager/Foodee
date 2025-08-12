package com.example.petproject1.ui.screen.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petproject1.data.OrderData
import com.example.petproject1.data.OrderDetailsState
import com.example.petproject1.ui.screen.cart.components.CartActionBar
import com.example.petproject1.ui.screen.cart.components.CartTopAppBar
import com.example.petproject1.ui.screen.cart.components.OrderDetailsSection
import com.example.petproject1.ui.screen.cart.components.OrderStepsSection

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    state: List<OrderDetailsState>,
    onAddItemClick: () -> Unit,
    onRemoveItemClick: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Content(
            state = state,
            onAddItemClick = onAddItemClick,
            onRemoveItemClick = onRemoveItemClick
        )
        CartActionBar(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(
                    horizontal = 18.dp,
                    vertical = 8.dp,
                ),
            orderState = OrderData,
            onClicked = {},
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    state: List<OrderDetailsState>,
    onAddItemClick: () -> Unit,
    onRemoveItemClick: () -> Unit,
) {
    val scrollableState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollableState),
    ) {
        CartTopAppBar(
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 24.dp),
        )
        OrderStepsSection(
            modifier = Modifier.padding(horizontal = 18.dp),
        )
        OrderDetailsSection(
            modifier = Modifier.padding(horizontal = 18.dp),
            state = state,
            onAddItemClick = onAddItemClick,
            onRemoveItemClick = onRemoveItemClick,
        )
    }
}