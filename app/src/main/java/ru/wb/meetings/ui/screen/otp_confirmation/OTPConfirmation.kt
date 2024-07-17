package ru.wb.meetings.ui.screen.otp_confirmation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import ru.wb.meetings.ui.component.MeetingTopBar
import ru.wb.meetings.ui.component.MeetingsTextButton
import ru.wb.meetings.ui.component.OneTimePassword
import ru.wb.meetings.ui.theme.Body2
import ru.wb.meetings.ui.theme.Heading2
import ru.wb.meetings.ui.theme.Subheading2

@Composable
fun OTPConfirmation(
    navController: NavHostController,
    viewModel: OTPConfirmationViewModel = koinViewModel()
) {
    Scaffold(
        topBar = { MeetingTopBar(
            label = "",
            modifier = Modifier.padding(start = 8.dp, end = 24.dp)
        ) },
        bottomBar = {  }
    ) { innerPadding ->
        OTPConfirmationContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        )
    }
}

@Composable
private fun OTPConfirmationContent(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.16f))
        Text(text = "Введите код", style = Heading2)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Отправили код на номер\n+7 999 999-99-99",
            style = Body2,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(0.1f))
        OneTimePassword(value = "", onValueChange = {}, actionDone = {})
        Spacer(modifier = Modifier.weight(0.14f))
        MeetingsTextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Запросить код повторно",
                style = Subheading2,

                )
        }
        Spacer(modifier = Modifier.weight(0.6f))
    }
}

@Preview(showSystemUi = true)
@Composable
private fun OTPConfirmationPreview() {
    Scaffold(
        topBar = { MeetingTopBar(
            label = "",
            modifier = Modifier.padding(start = 8.dp, end = 24.dp)
        ) },
        bottomBar = {  }
    ) { innerPadding ->
        OTPConfirmationContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        )
    }
}
