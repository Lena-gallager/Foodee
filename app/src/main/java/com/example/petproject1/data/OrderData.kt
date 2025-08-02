package com.example.petproject1.data

data class OrderState(
    val amount: Int,
    val totalPrice: String,
)

val OrderData = OrderState(
    amount = 5,
    totalPrice = "$27.45"
)