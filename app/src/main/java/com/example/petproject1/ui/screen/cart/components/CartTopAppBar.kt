package com.example.petproject1.ui.screen.cart.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petproject1.ui.components.TopAppBar
import com.example.petproject1.ui.theme.AppTheme

@Composable
fun CartTopAppBar(modifier: Modifier = Modifier) {
    Box(modifier = modifier.padding(24.dp)) {
        TopAppBar(
            headline = "My Cart",
            titleColor = AppTheme.colors.onBackground,
        )
    }
}
