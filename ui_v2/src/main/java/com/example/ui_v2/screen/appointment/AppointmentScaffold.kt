package com.example.ui_v2.screen.appointment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.component.LoadingButton
import com.example.ui_v2.component.LoadingButtonState
import com.example.ui_v2.component.TextField
import com.example.ui_v2.screen.appointment.component.AppointmentTitle
import com.example.ui_v2.screen.appointment.component.WBTextButton
import com.example.ui_v2.theme.MeetTheme

@Composable
internal fun AppointmentScaffold(
    title: @Composable () -> Unit,
    description: @Composable () -> Unit,
    inputField: @Composable () -> Unit,
    primaryButton: @Composable () -> Unit,
    hint: @Composable () -> Unit = {},
    secondaryButton: @Composable () -> Unit = {},
) {
    val paddingValues = WindowInsets.navigationBars.asPaddingValues()

    Column(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 20.dp,
                bottom = 28.dp + paddingValues.calculateBottomPadding()
            )
    ) {
        title()
        Spacer(modifier = Modifier.height(16.dp))
        description()
        Spacer(modifier = Modifier.height(24.dp))
        inputField()
        Spacer(modifier = Modifier.height(8.dp))
        hint()
        Spacer(modifier = Modifier.weight(1f))
        secondaryButton()
        Spacer(modifier = Modifier.height(24.dp))
        primaryButton()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AppointmentScaffoldPreview() {
    val textFieldState = rememberTextFieldState("")

    AppointmentScaffold(
        title = {
            AppointmentTitle(
                title = stringResource(R.string.event_application_title),
                onDismissClick = { }
            )
        },
        description = {
            Text(
                text = "Супертестировщики · 12 августа · Невский проспект, 11",
                style = MeetTheme.typo.bodyMedium
            )
        },
        inputField = {
            TextField(
                textFieldState = textFieldState,
                placeholder = "Имя и фамилия",
                modifier = Modifier.fillMaxWidth()
            )
        },
        hint = {
            Text(
                text = "Отправили код на +7 999 999-99-99",
                style = MeetTheme.typo.bodySmall,
                color = MeetTheme.colors.metadata,
            )
        },
        primaryButton = {
            LoadingButton(
                text = "Продолжить",
                onClick = { /*TODO*/ },
                loadingButtonState = LoadingButtonState.ACTIVE,
                modifier = Modifier.fillMaxWidth()
            )
        },
        secondaryButton = {
            WBTextButton(
                text = stringResource(R.string.get_new_code),
                enabled = true,
                onClick = { /*TODO*/ }
            )
        }
    )
}

