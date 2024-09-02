package com.example.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.theme.BrandDark
import com.example.presentation.theme.BrandDefault
import com.example.presentation.theme.ButtonFocusBorder
import com.example.presentation.theme.Disabled
import com.example.presentation.theme.DisabledContent
import com.example.presentation.theme.MeetTheme
import com.example.presentation.theme.Subheading1
import com.example.presentation.theme.activeGradient
import com.example.presentation.theme.secondaryGradient

@Composable
internal fun MeetButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    shape: Shape = CircleShape,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isFocused by interactionSource.collectIsFocusedAsState()

    Button(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(minWidth = 160.dp, minHeight = 68.dp)
            .border(
                width = 8.dp,
                color = if (isFocused) ButtonFocusBorder else Color.Transparent,
                shape = shape
            )
            .padding(8.dp),
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.run {
            buttonColors(
                containerColor = if (isHovered) BrandDark else BrandDefault,
                disabledContainerColor = BrandDefault.copy(alpha = 0.5f),
                disabledContentColor = Color.White
            )
        },
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
internal fun MeetingsOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    shape: Shape = CircleShape,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isFocused by interactionSource.collectIsFocusedAsState()

    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(minWidth = 160.dp, minHeight = 68.dp)
            .border(
                width = 8.dp,
                color = if (isFocused) ButtonFocusBorder else Color.Transparent,
                shape = shape
            )
            .background(color = Color.Transparent)
            .padding(8.dp),
        enabled = enabled,
        border = BorderStroke(
            width = if (isFocused) 1.dp else 2.dp,
            color = if (enabled) BrandDefault else BrandDefault.copy(alpha = 0.5f)),
        shape = shape,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(0.dp),
            contentColor = if (isHovered) BrandDark else BrandDefault,
            disabledContentColor = BrandDefault.copy(alpha = 0.5f)
        ),
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
internal fun MeetingsTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    shape: Shape = CircleShape,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isFocused by interactionSource.collectIsFocusedAsState()

    TextButton(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(minWidth = 160.dp, minHeight = 68.dp)
            .border(
                width = 8.dp,
                color = if (isFocused) ButtonFocusBorder else Color.Transparent,
                shape = shape
            )
            .padding(8.dp),
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.textButtonColors(
            contentColor = if (isHovered) BrandDark else BrandDefault,
            disabledContentColor = BrandDefault.copy(alpha = 0.5f),
        ),
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MeetingsButtonPreview() {
    MeetTheme {
        MeetButton(
            onClick = { /*TODO*/ },
            enabled = true
        ) {
            Text(text = "Button", fontSize = 16.sp)
        }
    }
}