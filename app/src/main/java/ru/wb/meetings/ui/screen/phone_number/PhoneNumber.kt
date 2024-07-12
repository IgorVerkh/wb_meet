package ru.wb.meetings.ui.screen.phone_number

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.wb.meetings.ui.component.MeetButton
import ru.wb.meetings.ui.component.MeetingTopBar
import ru.wb.meetings.ui.component.PhoneNumberTextField
import ru.wb.meetings.ui.theme.Body2
import ru.wb.meetings.ui.theme.Heading2
import ru.wb.meetings.ui.theme.Subheading2

@Composable
fun PhoneNumber(navController: NavHostController) {
    Scaffold(
        topBar = { MeetingTopBar(
            label = "",
            modifier = Modifier.padding(start = 8.dp, end = 24.dp)
        ) },
        bottomBar = {  }
    ) { innerPadding ->
        PhoneNumberContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        )
    }
}

@Composable
private fun PhoneNumberContent(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.16f))
        Text(text = "Введите номер телефона", style = Heading2)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Мы вышлем код подтверждения\nна указанный вами номер",
            style = Body2,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(0.1f))
        PhoneNumberTextField(value = "", onValueChange = {}, modifier = Modifier.height(36.dp))
        Spacer(modifier = Modifier.weight(0.14f))
        MeetButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
            enabled = false
        ) {
            Text(
                text = "Продолжить",
                style = Subheading2,

            )
        }
        Spacer(modifier = Modifier.weight(0.6f))
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PhoneNumberPreview() {
    Scaffold(
        topBar = { MeetingTopBar(
            label = "",
            modifier = Modifier.padding(start = 8.dp, end = 24.dp)
        ) },
        bottomBar = {  }
    ) { innerPadding ->
        PhoneNumberContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        )
    }
}
