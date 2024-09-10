package com.shivansh.androidstarter.ui.components.common

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun Loading(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier,
        strokeCap = StrokeCap.Round,
        strokeWidth = 4.dp,
        trackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
    )
}