package ru.wb.meetings.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R

@Composable
fun OverlappingRow(
    modifier: Modifier = Modifier,
    overlappingPercentage: Float,
    firstOnTop: Boolean = true,
    content: @Composable () -> Unit
) {

    val factor = (1 - overlappingPercentage)

    Layout(modifier = modifier, content = content, measurePolicy = { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        val widthsExceptFirst = placeables.subList(1, placeables.size).sumOf { it.width }
        val firstWidth = placeables.getOrNull(0)?.width ?: 0
        val width = (widthsExceptFirst * factor + firstWidth).toInt()
        val height = placeables.maxOf { it.height }
        layout(width, height) {
            var x = 0
            placeables.forEachIndexed { index, placeable ->
                placeable.placeRelative(
                    x, 0, if (firstOnTop) (placeables.size - index).toFloat() else 0f
                )
                x += (placeable.width * factor).toInt()
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
private fun OverlappingRowPreview() {
    OverlappingRow(overlappingPercentage = 0.3f) {
        repeat(6) {
            BorderedSquareAvatar(
                image = R.drawable.ic_group_placeholder,
                modifier = Modifier.size(size = 48.dp)
            )
        }
    }
}