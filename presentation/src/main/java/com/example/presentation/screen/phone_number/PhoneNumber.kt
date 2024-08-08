package com.example.presentation.screen.phone_number

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.presentation.R
import com.example.presentation.component.MeetButton
import com.example.presentation.component.MeetingTopBar
import com.example.presentation.component.PhoneNumberTextField
import com.example.presentation.navigation.Screen
import com.example.presentation.theme.Body2
import com.example.presentation.theme.Heading2
import com.example.presentation.theme.Subheading2
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun PhoneNumber(
    navController: NavHostController,
    viewModel: PhoneNumberViewModel = koinViewModel(),
) {
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            MeetingTopBar(
                label = "",
                modifier = Modifier.padding(start = 8.dp, end = 24.dp),
            )
        },
        bottomBar = { },
    ) { innerPadding ->
        PhoneNumberContent(
            phoneNumber = uiState.phoneNumber,
            selectedCountry = uiState.countryPhoneData,
            isContinueButtonEnabled = uiState.continueButtonEnabled,
            onCountryClick = { countryPhoneData -> viewModel.updateCountryCode(countryPhoneData) },
            onPhoneNumberChange = { phoneNumber -> viewModel.updatePhoneNumber(phoneNumber) },
            onContinueButtonClick = { navController.navigate(Screen.OTPConfirmation.route) },
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
        )
    }
}

@Composable
private fun PhoneNumberContent(
    phoneNumber: String,
    selectedCountry: CountryPhoneData,
    isContinueButtonEnabled: Boolean,
    onPhoneNumberChange: (String) -> Unit,
    onCountryClick: (CountryPhoneData) -> Unit,
    onContinueButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.weight(0.16f))
        Text(
            text = stringResource(R.string.input_phone_number),
            style = Heading2,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.we_send_code_to_phone_number),
            style = Body2,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.weight(0.1f))
        PhoneNumberTextField(
            value = phoneNumber,
            selectedCountry = selectedCountry,
            onValueChange = onPhoneNumberChange,
            onCountryClick = onCountryClick,
            modifier = Modifier.height(36.dp),
        )
        Spacer(modifier = Modifier.weight(0.14f))
        MeetButton(
            onClick = onContinueButtonClick,
            modifier =
            Modifier
                .fillMaxWidth(),
            enabled = isContinueButtonEnabled,
        ) {
            Text(
                text = stringResource(R.string.continue_button),
                style = Subheading2,
            )
        }
        Spacer(modifier = Modifier.weight(0.6f))
    }
}
