package com.example.petproject1.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.petproject1.R
import com.example.petproject1.ui.theme.AppTheme

@Composable
fun OrderCounterComponent(
    modifier: Modifier = Modifier,
    amount: Int,
    onAddItemClick: () -> Unit,
    onRemoveItemClick: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            SelectorButton(
                iconRes = R.drawable.ic_minus,
                contentColor = AppTheme.colors.onActionSurface,
                containerColor = AppTheme.colors.actionSurface,
                onClicked = onRemoveItemClick,
            )
            Text(
                text = amount.toString(),
                color = AppTheme.colors.onSurface,
                style = AppTheme.typography.titleLarge,
            )
            SelectorButton(
                iconRes = R.drawable.ic_plus,
                contentColor = AppTheme.colors.onSecondarySurface,
                containerColor = AppTheme.colors.secondarySurface,
                onClicked = onAddItemClick,
            )
        }
    }
}

@Composable
private fun SelectorButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    containerColor: Color,
    contentColor: Color,
    onClicked: () -> Unit,
) {
    Surface(
        modifier = modifier.size(24.dp),
        shape = CircleShape,
        color = containerColor,
        contentColor = contentColor,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = onClicked),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(7.dp),
            )
        }
    }
}
