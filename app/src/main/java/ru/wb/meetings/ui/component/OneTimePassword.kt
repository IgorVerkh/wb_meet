package ru.wb.meetings.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.theme.Heading1
import ru.wb.meetings.ui.theme.NeutralLine

private const val OTP_DEFAULT_LENGTH = 4

@Composable
fun OneTimePassword(
    value: String,
    onValueChange: (String) -> Unit,
    actionDone: (String) -> Unit,
    modifier: Modifier = Modifier,
    length: Int = OTP_DEFAULT_LENGTH
) {
    val focusManager = LocalFocusManager.current
    BasicTextField(modifier = modifier.height(40.dp),
        value = value,
        onValueChange = {
            if (it.length <= length) {
                onValueChange(it)
            }
            if (it.length >= length) {
                focusManager.clearFocus()
            }
        },
        decorationBox = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(length) { index ->
                    Spacer(modifier = Modifier.weight(0.1f))
                    OTPItem(
                        character = value.getOrNull(index),
                        modifier = Modifier.wrapContentHeight()
                    )
                }
                Spacer(modifier = Modifier.weight(0.1f))
            }
        },

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                actionDone(value)
            }
        )
    )
}

@Composable
fun OTPItem(
    character: Char?,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        if (character == null) {
            Canvas(modifier = Modifier.size(24.dp)) {
                drawCircle(NeutralLine)
            }
        } else {
            Text(
                text = character.toString(),
                style = Heading1
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun OneTimePasswordPreview() {

    var password by remember { mutableStateOf("77") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        OneTimePassword(
            value = password,
            onValueChange = {},
            actionDone = {},
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

