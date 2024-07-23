package com.example.presentation.screen.profile_creation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.presentation.R
import com.example.presentation.component.MeetButton
import com.example.presentation.component.MeetingTopBar
import com.example.presentation.component.MeetingsTextField
import com.example.presentation.component.RoundAvatarEdit
import com.example.presentation.theme.Subheading2
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ProfileCreation(
    navController: NavHostController,
    viewModel: ProfileCreationViewModel = koinViewModel()
) {
    Scaffold(
        topBar = { MeetingTopBar(
            label = "Профиль",
            modifier = Modifier.padding(start = 8.dp, end = 24.dp)
        ) },
        bottomBar = {  }
    ) { innerPadding ->
        ProfileCreationContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        )
    }
}

@Composable
private fun ProfileCreationContent(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.1f))
        RoundAvatarEdit(
            image = R.drawable.ic_avatar_placeholder,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.weight(0.08f))
        MeetingsTextField(
            value = "",
            onValueChange = { /*TODO*/ },
            placeholder = stringResource(R.string.create_profile_name_placeholder)
        )
        Spacer(modifier = Modifier.height(12.dp))
        MeetingsTextField(
            value = "",
            onValueChange = { /*TODO*/ },
            placeholder = stringResource(R.string.create_profile_surname_placeholder)
        )
        Spacer(modifier = Modifier.weight(0.12f))
        MeetButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        ) {
            Text(
                text = stringResource(R.string.save_button),
                style = Subheading2,

                )
        }
        Spacer(modifier = Modifier.weight(0.7f))
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ProfileCreationPreview() {
    Scaffold(
        topBar = { MeetingTopBar(
            label = "Профиль",
            modifier = Modifier.padding(start = 8.dp, end = 24.dp)
        ) },
        bottomBar = {  }
    ) { innerPadding ->
        ProfileCreationContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        )
    }
}