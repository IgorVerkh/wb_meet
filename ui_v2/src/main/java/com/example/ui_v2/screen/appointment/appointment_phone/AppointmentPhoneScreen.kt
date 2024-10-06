package com.example.ui_v2.screen.appointment.appointment_phone

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
import com.example.ui_v2.common.CountryPhoneData
import com.example.ui_v2.component.LoadingButton
import com.example.ui_v2.component.LoadingButtonState
import com.example.ui_v2.component.PhoneNumberTextField
import com.example.ui_v2.screen.appointment.AppointmentScaffold
import com.example.ui_v2.screen.appointment.component.AppointmentTitle
import com.example.ui_v2.theme.MeetTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun AppointmentPhoneScreen(
    navController: NavHostController,
    viewModel: AppointmentPhoneViewModel = koinViewModel(),
) {
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    AppointmentPhoneContent(
        textFieldState = uiState.textFieldState,
        description = uiState.description,
        primaryActionButtonState = uiState.primaryActionButtonState,
        selectedCountry = uiState.selectedCountry,
        onCountryClick = { /*TODO*/ },
        onContinueClick = { /*TODO*/ },
        onDismissClick = { /*TODO*/ },
    )
}

@Composable
private fun AppointmentPhoneContent(
    textFieldState: TextFieldState,
    description: String,
    primaryActionButtonState: LoadingButtonState,
    selectedCountry: CountryPhoneData,
    onCountryClick: (CountryPhoneData) -> Unit,
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
            PhoneNumberTextField(
                textFieldState = textFieldState,
                selectedCountry = selectedCountry,
                onCountryClick = onCountryClick
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