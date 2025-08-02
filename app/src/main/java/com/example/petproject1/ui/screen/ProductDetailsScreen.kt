package com.example.petproject1.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petproject1.data.OrderData
import com.example.petproject1.data.OrderState
import com.example.petproject1.data.ProductDescriptionData
import com.example.petproject1.data.ProductFlavorState
import com.example.petproject1.data.ProductFlavorsData
import com.example.petproject1.data.ProductNutritionData
import com.example.petproject1.data.ProductNutritionState
import com.example.petproject1.data.ProductPreviewState
import com.example.petproject1.ui.screen.components.FlavorSection
import com.example.petproject1.ui.screen.components.OrderActionBar
import com.example.petproject1.ui.screen.components.ProductDescriptionSection
import com.example.petproject1.ui.screen.components.ProductNutritionSection
import com.example.petproject1.ui.screen.components.ProductPreviewSection

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState = ProductPreviewState(),
    productFlavors: List<ProductFlavorState> = ProductFlavorsData,
    productNutritionState: ProductNutritionState = ProductNutritionData,
    productDescription: String = ProductDescriptionData,
    orderState: OrderState = OrderData,
    onAddItemClick: () -> Unit,
    onRemoveItemClick: () -> Unit,
    onCheckOutItemClick: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Content(
            productPreviewState = productPreviewState,
            productFlavors = productFlavors,
            productNutritionState = productNutritionState,
            productDescription = productDescription,
        )
        OrderActionBar(
            state = orderState,
            onAddItemClick = onAddItemClick,
            onRemoveItemClick = onRemoveItemClick,
            onCheckOutItemClick = onCheckOutItemClick,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(
                    horizontal = 18.dp,
                    vertical = 8.dp,
                )
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState,
    productFlavors: List<ProductFlavorState>,
    productNutritionState: ProductNutritionState,
    productDescription: String,
) {
    val scrollableState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollableState)
    ) {
        ProductPreviewSection(
            state = productPreviewState,
        )
        Spacer(
            modifier = Modifier.height(16.dp),
        )
        FlavorSection(
            modifier = Modifier.padding(horizontal = 18.dp),
            data = productFlavors,
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        ProductNutritionSection(
            modifier = Modifier.padding(horizontal = 18.dp),
            state = productNutritionState,
        )
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        ProductDescriptionSection(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(horizontal = 18.dp)
                .padding(bottom = 128.dp),
            productDescription = productDescription,
        )
    }
}
