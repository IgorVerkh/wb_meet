package com.example.ui_v2.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.theme.MeetTheme

@Composable
internal fun SearchField(
    textFieldState: TextFieldState,
    onClearClick: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(R.string.find_events_and_communities),
) {
    val leadingIcon = @Composable {
        Image(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier.size(size = 18.dp)
        )
    }
    val trailingIcon = @Composable {
        Image(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = null,
            modifier = Modifier
                .size(size = 18.dp)
                .clickable { onClearClick() }
        )
    }

    BaseTextField(
        textFieldState = textFieldState,
        leadingIcon = if (textFieldState.text.isEmpty()) {
            leadingIcon
        } else null,
        trailingIcon = if (textFieldState.text.isNotEmpty()) {
            trailingIcon
        } else null,
        placeholder = placeholder,
        textStyle = MeetTheme.typo.bodySmall,
        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 12.dp),
        modifier = modifier,
    )
}

@Preview(showSystemUi = true)
@Composable
private fun SearchFieldPreview() {
    val textFieldState = rememberTextFieldState("")

    SearchField(
        textFieldState = textFieldState,
        onClearClick = { textFieldState.clearText() },
        modifier = Modifier.fillMaxWidth()
    )
}