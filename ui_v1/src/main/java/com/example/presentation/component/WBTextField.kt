package com.example.presentation.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.example.presentation.common.conditional
import com.example.presentation.theme.MeetTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun WBTextField(
    textFieldState: TextFieldState,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    isError: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val isFocused by interactionSource.collectIsFocusedAsState()
    val isEmpty = textFieldState.text.toString() == ""
    val borderColor = MeetTheme.colors.brandColorDefault
    val backgroundColor =
        if (isError) MeetTheme.colors.error.copy(alpha = 0.1f) else MeetTheme.colors.disabled

    BasicTextField2(
        state = textFieldState,
        modifier = modifier,
        enabled = enabled,
        decorator = { innerTextField ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(backgroundColor)
                    .conditional(isFocused) {
                        border(
                            width = 1.dp,
                            color = borderColor,
                            shape = RoundedCornerShape(16.dp)
                        )
                    }
                    .padding(horizontal = 12.dp, vertical = 16.dp)
            ) {
                if (isEmpty) {
                    Text(text = placeholder, color = MeetTheme.colors.neutralColorDisabled)
                } else {
                    innerTextField()
                }
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun WBTextFieldPreview() {
    val textFieldState = rememberTextFieldState("Вячеслав Константинопольский")

    WBTextField(
        textFieldState = textFieldState,
        modifier = Modifier,
        placeholder = "Имя и фамилия"
    )
}