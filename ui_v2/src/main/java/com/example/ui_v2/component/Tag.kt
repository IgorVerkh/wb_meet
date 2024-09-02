package com.example.ui_v2.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_v2.theme.Disabled
import com.example.ui_v2.theme.MeetTheme
import com.example.ui_v2.theme.Primary

/*
* Big Tag - text 22.dp
*            used in editing interests screen (clickable)
*
* Medium Tag - text 16.dp;
*               used in profile screen in editing mode (clickable)
*               used in meeting cards (not clickable)
*               used in other meetings block (clickable)
*
* Small Tag - text 14.dp;
*              used in profile screen (not clickable)
*              used in profile cards (not clickable)
*/

internal enum class TagState {
    ACTIVE,
    SECONDARY,
    // TODO: Add REMOVABLE state to improve UI
}

internal data class TagColors(
    val activeTextColor: Color = Disabled,
    val secondaryTextColor: Color = Primary,
    val activeContainerColor: Color = Primary,
    val secondaryContainerColor: Color = Disabled,
)

@Composable
internal fun Tag(
    text: String,
    onClick: () -> Unit,
    state: TagState,
    fontSize: TextUnit,
    paddingValues: PaddingValues,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    colors: TagColors = TagColors(),
    // TODO: Add trailing icon parameter to improve UI
) {
    val textColor = when (state) {
        TagState.ACTIVE -> colors.activeTextColor
        TagState.SECONDARY -> colors.secondaryTextColor
    }
    val containerColor = when (state) {
        TagState.ACTIVE -> colors.activeContainerColor
        TagState.SECONDARY -> colors.secondaryContainerColor
    }

    Box(
        modifier = modifier
            .background(
                color = containerColor,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(paddingValues)
            .clickable(enabled = enabled) { onClick() },
    ) {
        Text(
            style = MeetTheme.typo.bodyMedium,
            color = textColor,
            fontSize = fontSize,
            text = text
        )
    }
}

@Composable
internal fun SmallTag(
    text: String,
    onClick: () -> Unit,
    state: TagState,
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
) {
    Tag(
        text = text,
        onClick = onClick,
        state = state,
        fontSize = 14.sp,
        paddingValues = PaddingValues(horizontal = 6.dp, vertical = 3.dp),
        enabled = enabled,
        modifier = modifier,
    )
}

@Composable
internal fun MediumTag(
    text: String,
    onClick: () -> Unit,
    state: TagState,
    enabled: Boolean,
    modifier: Modifier = Modifier,
) {
    Tag(
        text = text,
        onClick = onClick,
        state = state,
        fontSize = 16.sp,
        paddingValues = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        enabled = enabled,
        modifier = modifier,
    )
}

@Composable
internal fun BigTag(
    text: String,
    onClick: () -> Unit,
    state: TagState,
    enabled: Boolean,
    modifier: Modifier = Modifier,
) {
    Tag(
        text = text,
        onClick = onClick,
        state = state,
        fontSize = 22.sp,
        paddingValues = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
        enabled = enabled,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun SmallTagPreview() {
    SmallTag(
        text = "Backend",
        onClick = {},
        state = TagState.ACTIVE
    )
}

@Preview
@Composable
private fun MediumTagPreview() {
    MediumTag(
        text = "Backend",
        onClick = {},
        state = TagState.SECONDARY,
        enabled = false
    )
}

@Preview
@Composable
private fun BigTagPreview() {
    BigTag(
        text = "Backend",
        onClick = {},
        state = TagState.ACTIVE,
        enabled = true
    )
}