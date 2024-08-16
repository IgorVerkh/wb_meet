package com.example.presentation.component

import android.content.res.Resources.Theme
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.MaterialTheme
import com.example.presentation.theme.BrandDefault
import com.example.presentation.theme.Disabled
import com.example.presentation.theme.MeetTheme

@Composable
internal fun Toggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    width: Dp = 48.dp,
    height: Dp = 24.dp,
    // TODO: make ToggleColors
    // TODO: add disabled coloring
    checkedTrackColor: Color = BrandDefault,
    uncheckedTrackColor: Color = Disabled,
    gapBetweenThumbAndTrackEdge: Dp = 1.5.dp,
) {
    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge

    val animatePosition = animateFloatAsState(
        targetValue = if (checked)
            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
        else
            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() },
        label = "animate"
    )

    Canvas(
        modifier = modifier
            .size(width = width, height = height)
            .toggleable(
                value = checked,
                enabled = enabled,
                role = Role.Switch
            ) {
                onCheckedChange(checked)
            }
    ) {
        drawRoundRect(
            color = if (checked) checkedTrackColor else uncheckedTrackColor,
            cornerRadius = CornerRadius(x = 20.dp.toPx(), y = 20.dp.toPx()),
        )

        drawCircle(
            color = Color.White,
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            )
        )
    }
}

@Preview
@Composable
private fun TogglePreview() {
    var checked by remember { mutableStateOf(true) }
    MeetTheme {
        Toggle(
            checked = checked,
            onCheckedChange = { checked = !checked },
            checkedTrackColor = MaterialTheme.colors.primary
        )
    }
}
