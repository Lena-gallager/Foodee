package com.example.petproject1.ui.screen.productDetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.petproject1.R
import com.example.petproject1.data.ProductPreviewState
import com.example.petproject1.ui.components.TopAppBar
import com.example.petproject1.ui.theme.AppTheme

@Composable
fun ProductPreviewSection(
    modifier: Modifier = Modifier,
    state: ProductPreviewState,
) {
    Box(modifier = modifier.height(IntrinsicSize.Max)) {
        ProductBackground(
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Content(
            state = state,
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 24.dp),
        )
    }
}

@Composable
private fun ProductBackground(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = AppTheme.colors.secondarySurface,
                shape = RoundedCornerShape(
                    bottomStart = 32.dp,
                    bottomEnd = 32.dp,
                )
            )
    )
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    state: ProductPreviewState,
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (actionBar, highlights, productImg) = createRefs()

        TopAppBar(
            headline = "Mr. Cheezy",
            titleColor = AppTheme.colors.onSecondarySurface,
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .constrainAs(actionBar) {
                    top.linkTo(parent.top)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.img_burger),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(256.dp)
                .constrainAs(productImg) {
                    end.linkTo(parent.end)
                    top.linkTo(anchor = actionBar.bottom, margin = 20.dp)
                }
        )

        ProductHighlights(
            highlights = state.highlights,
            modifier = Modifier.constrainAs(highlights){
                start.linkTo(anchor = parent.start, margin = 19.dp)
                top.linkTo(productImg.top)
            }
        )
    }
}
