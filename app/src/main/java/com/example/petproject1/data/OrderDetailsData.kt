package com.example.petproject1.data

data class OrderDetailsState(
    val productData: ProductPreviewState,
    val orderState: OrderState,
)

val OrderDetailsData = listOf(
    OrderDetailsState(
        productData = BurgerProduct,
        orderState = OrderData,
    ),
    OrderDetailsState(
        productData = FriesProduct,
        orderState = OrderData,
    )
)
