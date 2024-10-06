package com.example.ui_v2.screen.appointment.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ui_v2.theme.MeetTheme

@Composable
internal fun WBTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {

    val color = when (enabled) {
        true -> MeetTheme.colors.primary
        false -> MeetTheme.colors.metadata
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = enabled) { onClick() },
    ) {
        Text(
            text = text,
            style = MeetTheme.typo.bodySmall,
            color = color,
        )
    }
}