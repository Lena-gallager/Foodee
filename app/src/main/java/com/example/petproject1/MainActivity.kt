package com.example.petproject1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.petproject1.data.OrderDetailsData
import com.example.petproject1.data.OrderState
import com.example.petproject1.ui.screen.cart.CartScreen
import com.example.petproject1.ui.screen.productDetails.ProductDetailsScreen
import com.example.petproject1.ui.theme.AppTheme

private const val PRODUCT_PRICE_PER_UNIT = 5.25
private const val PRODUCT_CURRENCY = "$"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var amount by remember { mutableIntStateOf(5) }
            val orderState by remember {
                mutableStateOf(
                    OrderState(
                        amount = amount,
                        totalPrice = "${PRODUCT_CURRENCY}${amount + PRODUCT_PRICE_PER_UNIT}"
                    )
                )
            }
            val orderDetailsState by remember {
                mutableStateOf(OrderDetailsData)
            }
            AppTheme {
                CartScreen(
                    state = orderDetailsState,
                    onAddItemClick = { amount = amount.inc() },
                    onRemoveItemClick = { if (amount > 0) amount = amount.dec() },
                )
//                ProductDetailsScreen(
//                    onAddItemClick = { amount = amount.inc() },
//                    onRemoveItemClick = { if (amount > 0) amount = amount.dec() },
//                    onCheckOutItemClick = {},
//                    orderState = orderState,
//                )
            }
        }
    }
}
