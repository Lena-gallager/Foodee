package com.example.petproject1.data

import androidx.annotation.DrawableRes
import com.example.petproject1.R

data class ProductHighlightState(
    val text: String,
    val type: ProductHighlightType,
)

enum class ProductHighlightType {
    PRIMARY,
    SECONDARY,
}

data class ProductPreviewState(
    val headline: String = "Mr. Cheezy",
    @DrawableRes val productImg: Int = R.drawable.img_burger,
    val highlights: List<ProductHighlightState> = listOf(
        ProductHighlightState(
            text = "Classic Taste",
            type = ProductHighlightType.SECONDARY,
        ),
        ProductHighlightState(
            text = "Bestseller",
            type = ProductHighlightType.PRIMARY,
        )
    )
)

val BurgerProduct = ProductPreviewState(
    headline = "Mr. Cheezy",
    productImg = R.drawable.img_burger,
    highlights = listOf(
        ProductHighlightState(
            text = "Classic Taste",
            type = ProductHighlightType.SECONDARY,
        ),
        ProductHighlightState(
            text = "Bestseller",
            type = ProductHighlightType.PRIMARY,
        )
    ),
)

val FriesProduct = ProductPreviewState(
    headline = "Fries M",
    productImg = R.drawable.img_fries,
    highlights = listOf(
        ProductHighlightState(
            text = "Classic Taste",
            type = ProductHighlightType.SECONDARY,
        ),
        ProductHighlightState(
            text = "Bestseller",
            type = ProductHighlightType.PRIMARY,
        )
    ),
)
