package com.example.ui_v2.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.common.conditional
import com.example.ui_v2.theme.MeetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BaseTextField(
    textFieldState: TextFieldState,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    isError: Boolean = false,
    textStyle: TextStyle = MeetTheme.typo.bodyMedium,
    singleLine: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 16.dp),
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default,
    inputTransformation: InputTransformation? = null,
    outputTransformation: OutputTransformation? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val isFocused by interactionSource.collectIsFocusedAsState()
    val borderColor = MeetTheme.colors.brandColorDefault
    val backgroundColor =
        if (isError) MeetTheme.colors.error.copy(alpha = 0.1f) else MeetTheme.colors.disabled

    BasicTextField(
        state = textFieldState,
        modifier = modifier
            .conditional(isFocused) {
                border(
                    width = 1.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(16.dp)
                )
            },
        enabled = enabled,
        textStyle = textStyle,
        lineLimits = lineLimits,
        inputTransformation = inputTransformation,
        outputTransformation = outputTransformation,
        decorator = { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = textFieldState.text.toString(),
                innerTextField = { innerTextField() },
                placeholder = { Text(text = placeholder, style = textStyle) },
                enabled = enabled,
                singleLine = singleLine,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                shape = RoundedCornerShape(16.dp),
                contentPadding = contentPadding,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = backgroundColor,
                    disabledContainerColor = backgroundColor,
                    unfocusedContainerColor = backgroundColor,
                    unfocusedPlaceholderColor = MeetTheme.colors.neutralColorDisabled,
                    disabledPlaceholderColor = MeetTheme.colors.neutralColorDisabled,
                    errorPlaceholderColor = MeetTheme.colors.neutralColorDisabled,
                ),
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
            )
        }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun WBTextFieldPreview() {
    val textFieldState = rememberTextFieldState("")

    BaseTextField(
        textFieldState = textFieldState,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        placeholder = "Найти встречи и сообщества",
        trailingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                modifier = Modifier.size(size = 22.dp)
            )
        },
    )
}

