package com.example.petproject1.ui.screen.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.petproject1.data.OrderStep
import com.example.petproject1.ui.theme.AppTheme

@Composable
fun OrderStepsSection(
    modifier: Modifier = Modifier,
    currentStep: OrderStep = OrderStep.MY_ORDER,
    onStepClick: (OrderStep) -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StepIndicator(
            text = "My Order",
            stepNumber = 1,
            isActive = currentStep == OrderStep.MY_ORDER,
            onClick = { onStepClick(OrderStep.MY_ORDER) }
        )
        StepIndicator(
            text = "Details",
            stepNumber = 2,
            isActive = currentStep == OrderStep.DETAILS,
            onClick = { onStepClick(OrderStep.DETAILS) }
        )
        StepIndicator(
            text = "Payment",
            stepNumber = 3,
            isActive = currentStep == OrderStep.PAYMENT,
            onClick = { onStepClick(OrderStep.PAYMENT) }
        )
    }
}

@Composable
fun StepIndicator(
    text: String,
    stepNumber: Int,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = text,
            color = if (isActive) AppTheme.colors.onBackground else Color.Gray,
            style = AppTheme.typography.bodySmall,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = if (isActive) AppTheme.colors.secondarySurface else Color.LightGray,
                    shape = CircleShape,
                )
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = stepNumber.toString(),
                color = AppTheme.colors.onHighlightSurface,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}
