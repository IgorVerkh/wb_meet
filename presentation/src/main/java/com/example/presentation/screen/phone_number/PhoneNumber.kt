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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.presentation.R
import com.example.presentation.component.MeetButton
import com.example.presentation.component.MeetingTopBar
import com.example.presentation.component.PhoneNumberTextField
import com.example.presentation.theme.Body2
import com.example.presentation.theme.Heading2
import com.example.presentation.theme.Subheading2
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun PhoneNumber(
    navController: NavHostController,
    viewModel: PhoneNumberViewModel = koinViewModel()
) {
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
        Text(
            text = stringResource(R.string.input_phone_number),
            style = Heading2
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.we_send_code_to_phone_number),
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
                text = stringResource(R.string.continue_button),
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
