package com.example.ui_v2.screen.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.component.SearchField
import com.example.ui_v2.theme.MeetTheme

@Composable
internal fun SearchBar(
    textFieldState: TextFieldState,
    onClearClick: () -> Unit,
    onUserClick: () -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(R.string.find_events_and_communities),
) {
    val actionState = when (textFieldState.text.isNotEmpty()) {
        true -> {
            TrailingActionState.SEARCH
        }

        false -> {
            TrailingActionState.DEFAULT
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        SearchField(
            textFieldState = textFieldState,
            onClearClick = onClearClick,
            placeholder = placeholder,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        SearchBarTrailingAction(
            trailingActionState = actionState,
            onUserClick = onUserClick,
            onCancelClick = onCancelClick,
        )
    }

}

private enum class TrailingActionState {
    DEFAULT,
    SEARCH,
}

@Composable
private fun SearchBarTrailingAction(
    trailingActionState: TrailingActionState,
    onUserClick: () -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (trailingActionState) {
        TrailingActionState.DEFAULT -> {
            IconButton(
                onClick = onUserClick,
                modifier = modifier,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = null,
                    tint = MeetTheme.colors.primary
                )
            }
        }

        TrailingActionState.SEARCH -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .clickable { onCancelClick() }
            ) {
                Text(
                    text = stringResource(R.string.cancel),
                    style = MeetTheme.typo.labelMedium,
                    color = MeetTheme.colors.primary
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SearchBarPreview() {
    val textFieldState = rememberTextFieldState("h")

    SearchBar(
        textFieldState = textFieldState,
        onClearClick = { textFieldState.clearText() },
        onUserClick = { },
        onCancelClick = { },
    )
}