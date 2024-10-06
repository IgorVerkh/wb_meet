package com.example.ui_v2.screen.appointment.appointment_code

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.then
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.ui_v2.R
import com.example.ui_v2.component.LoadingButton
import com.example.ui_v2.component.TextField
import com.example.ui_v2.screen.appointment.AppointmentScaffold
import com.example.ui_v2.screen.appointment.component.AppointmentTitle
import com.example.ui_v2.screen.appointment.component.WBTextButton
import com.example.ui_v2.text_transformation.input.OnlyDigitsTransformation
import com.example.ui_v2.theme.MeetTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun AppointmentCodeScreen(
    navController: NavHostController,
    viewModel: AppointmentCodeViewModel = koinViewModel(),
) {
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    AppointmentCodeContent(
        state = uiState,
        onContinueClick = { /*TODO*/ },
        onDismissClick = { /*TODO*/ },
        onResendCodeClick = { /*TODO*/ }
    )
}

@Composable
private fun AppointmentCodeContent(
    state: AppointmentCodeState,
    onContinueClick: () -> Unit,
    onDismissClick: () -> Unit,
    onResendCodeClick: () -> Unit,
) {
    AppointmentScaffold(
        title = {
            AppointmentTitle(
                title = stringResource(R.string.event_application_title),
                onDismissClick = { onDismissClick() }
            )
        },
        description = {
            Text(
                text = state.description,
                style = MeetTheme.typo.bodyMedium
            )
        },
        inputField = {
            TextField(
                textFieldState = state.textFieldState,
                placeholder = "0000",
                inputTransformation = OnlyDigitsTransformation.then(
                    InputTransformation.maxLength(4)
                )
            )
        },
        hint = {
            Text(
                text = state.hint,
                style = MeetTheme.typo.bodySmall,
                color = MeetTheme.colors.metadata,
            )
        },
        primaryButton = {
            LoadingButton(
                text = stringResource(R.string.send_and_submit_code),
                onClick = { onContinueClick() },
                loadingButtonState = state.primaryActionButtonState,
                modifier = Modifier.fillMaxWidth()
            )
        },
        secondaryButton = {
            WBTextButton(
                text = stringResource(R.string.get_new_code),
                enabled = true,
                onClick = onResendCodeClick
            )
        })
}