package ru.wb.meetings.ui.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.Body1
import ru.wb.meetings.ui.theme.NeutralDisabled
import ru.wb.meetings.ui.theme.NeutralOffWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier
            .height(36.dp)
            .fillMaxWidth(),
        interactionSource = interactionSource,
        enabled = enabled,
        singleLine = singleLine,
        textStyle = Body1
    ) {
        TextFieldDefaults.DecorationBox(
            value = text,
            innerTextField = it,
            singleLine = singleLine,
            enabled = enabled,
            visualTransformation = VisualTransformation.None,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = NeutralDisabled
                )
            },
            placeholder = { Text(text = "Поиск", style = Body1) },
            interactionSource = interactionSource,
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                top = 2.dp,
                bottom = 2.dp,
            ),
            shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = NeutralOffWhite,
                focusedContainerColor = NeutralOffWhite,
                unfocusedPlaceholderColor = NeutralDisabled,
                focusedPlaceholderColor = NeutralDisabled,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar(
        text = "",
        onValueChange = {}
    )
}