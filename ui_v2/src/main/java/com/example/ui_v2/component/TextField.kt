package com.example.ui_v2.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui_v2.theme.MeetTheme

@Composable
internal fun TextField(
    textFieldState: TextFieldState,
    placeholder: String,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = true,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.SingleLine,
    inputTransformation: InputTransformation? = null,
    outputTransformation: OutputTransformation? = null,
) {
    BaseTextField(
        textFieldState = textFieldState,
        textStyle = MeetTheme.typo.bodyMedium,
        placeholder = placeholder,
        singleLine = singleLine,
        leadingIcon = leadingIcon,
        lineLimits = lineLimits,
        inputTransformation = inputTransformation,
        outputTransformation = outputTransformation,
        modifier = modifier,
    )
}

@Preview(showSystemUi = true)
@Composable
private fun TextFieldPreview() {
    val textFieldState = rememberTextFieldState("About About About About")

    TextField(
        textFieldState = textFieldState,
        placeholder = "Имя и фамилия",
        singleLine = false,
        lineLimits = TextFieldLineLimits.MultiLine(maxHeightInLines = 3),
        modifier = Modifier
            .fillMaxWidth()
    )
}