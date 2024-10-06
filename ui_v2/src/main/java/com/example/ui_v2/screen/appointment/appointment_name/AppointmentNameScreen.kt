package com.example.ui_v2.screen.appointment.appointment_name

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.ui_v2.R
import com.example.ui_v2.component.LoadingButton
import com.example.ui_v2.component.LoadingButtonState
import com.example.ui_v2.component.TextField
import com.example.ui_v2.screen.appointment.AppointmentScaffold
import com.example.ui_v2.screen.appointment.component.AppointmentTitle
import com.example.ui_v2.theme.MeetTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun AppointmentNameScreen(
    navController: NavHostController,
    viewModel: AppointmentNameViewModel = koinViewModel(),
) {
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    AppointmentNameContent(
        textFieldState = uiState.textFieldState,
        description = uiState.description,
        primaryActionButtonState = uiState.primaryActionButtonState,
        onContinueClick = { /*TODO*/ },
        onDismissClick = { /*TODO*/ },
    )
}

@Composable
private fun AppointmentNameContent(
    textFieldState: TextFieldState,
    description: String,
    primaryActionButtonState: LoadingButtonState,
    onContinueClick: () -> Unit,
    onDismissClick: () -> Unit,
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
                text = description,
                style = MeetTheme.typo.bodyMedium
            )
        },
        inputField = {
            TextField(
                textFieldState = textFieldState,
                placeholder = stringResource(R.string.name_surname_placeholder),
                modifier = Modifier.fillMaxWidth()
            )
        },
        primaryButton = {
            LoadingButton(
                text = stringResource(R.string.continue_action),
                onClick = { onContinueClick() },
                loadingButtonState = primaryActionButtonState,
                modifier = Modifier.fillMaxWidth()
            )
        })
}