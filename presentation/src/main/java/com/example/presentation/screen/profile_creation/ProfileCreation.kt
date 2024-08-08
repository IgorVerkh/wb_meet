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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.presentation.R
import com.example.presentation.component.MeetButton
import com.example.presentation.component.MeetingTopBar
import com.example.presentation.component.MeetingsTextField
import com.example.presentation.component.RoundAvatarEdit
import com.example.presentation.navigation.Graph
import com.example.presentation.theme.Subheading2
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ProfileCreation(
    navController: NavHostController,
    viewModel: ProfileCreationViewModel = koinViewModel(),
) {
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            MeetingTopBar(
                label = stringResource(R.string.profile_top_bar),
                modifier = Modifier.padding(start = 8.dp, end = 24.dp)
            )
        },
        bottomBar = { }
    ) { innerPadding ->
        // It would be better to add Action class instead of calling vm methods ofc
        // but I'm not that inclined to refactor that
        ProfileCreationContent(
            avatar = uiState.avatar,
            name = uiState.name,
            onNameChange = { name -> viewModel.updateName(name) },
            secondName = uiState.secondName,
            onSecondNameChange = { secondName -> viewModel.updateSecondName(secondName) },
            isSaveButtonEnabled = uiState.isSaveButtonEnabled,
            onSaveButtonClick = { navController.navigate(Graph.MeetingsGraph.route) },
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        )
    }
}

@Composable
private fun ProfileCreationContent(
    avatar: Any?,
    name: String,
    onNameChange: (String) -> Unit,
    secondName: String,
    onSecondNameChange: (String) -> Unit,
    isSaveButtonEnabled: Boolean,
    onSaveButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.1f))
        RoundAvatarEdit(
            image = avatar,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.weight(0.08f))
        MeetingsTextField(
            value = name,
            onValueChange = onNameChange,
            placeholder = stringResource(R.string.create_profile_name_placeholder)
        )
        Spacer(modifier = Modifier.height(12.dp))
        MeetingsTextField(
            value = secondName,
            onValueChange = onSecondNameChange,
            placeholder = stringResource(R.string.create_profile_surname_placeholder)
        )
        Spacer(modifier = Modifier.weight(0.12f))
        MeetButton(
            onClick = onSaveButtonClick,
            modifier = Modifier.fillMaxWidth(),
            enabled = isSaveButtonEnabled
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
        topBar = {
            MeetingTopBar(
                label = "Профиль",
                modifier = Modifier.padding(start = 8.dp, end = 24.dp)
            )
        },
        bottomBar = { }
    ) { innerPadding ->
        ProfileCreationContent(
            avatar = null,
            name = "",
            secondName = "",
            onNameChange = {},
            onSecondNameChange = {},
            isSaveButtonEnabled = false,
            onSaveButtonClick = {},
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        )
    }
}