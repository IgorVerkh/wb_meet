package com.example.ui_v2.screen.interests

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.ui_v2.R
import com.example.ui_v2.component.BigTag
import com.example.ui_v2.component.LoadingButton
import com.example.ui_v2.component.LoadingButtonState
import com.example.ui_v2.component.TagState
import com.example.ui_v2.theme.MeetTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun InterestsScreen(
    navController: NavHostController,
    viewModel: InterestsViewModel = koinViewModel(),
) {
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    InterestsContent(
        interestsMap = uiState.interestsMap,
        saveButtonState = uiState.saveButtonState,
        onSaveClick = { /*TODO*/ },
        onPostponeClick = { /*TODO*/ },
        onTagClick = { /*TODO*/ }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun InterestsContent(
    interestsMap: Map<String, Boolean>,
    saveButtonState: LoadingButtonState,
    onSaveClick: () -> Unit,
    onPostponeClick: () -> Unit,
    onTagClick: (String) -> Unit,
) {
    val scrollState = rememberScrollState()
    val paddingValues = WindowInsets.navigationBars.asPaddingValues()

    Column(
        modifier = Modifier
            .padding(
                start = 12.dp,
                end = 12.dp,
                top = 20.dp,
                bottom = 28.dp + paddingValues.calculateBottomPadding()
            )
    ) {
        Text(
            stringResource(R.string.interests_title),
            style = MeetTheme.typo.displayLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            stringResource(R.string.interests_description),
            style = MeetTheme.typo.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)

        ) {
            interestsMap.forEach { (label, isActive) ->
                BigTag(
                    text = label,
                    onClick = { onTagClick(label) },
                    state = if (isActive) TagState.ACTIVE else TagState.SECONDARY,
                    enabled = true
                )
            }
        }
        LoadingButton(
            text = stringResource(R.string.save),
            onClick = { onSaveClick() },
            loadingButtonState = saveButtonState,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onPostponeClick() }
        ) {
            Text(
                text = stringResource(R.string.interests_postpone),
                style = MeetTheme.typo.titleSmall,
                color = MeetTheme.colors.metadata
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun InterestsPreview() {
    val interestsMap = mapOf(
        "Design" to false,
        "Development" to true,
        "Product management" to false,
        "Project management" to false,
        "Backend" to true,
        "Frontend" to false,
        "Mobile" to false,
        "Тестирование" to false,
        "Продажи" to false,
        "Бизнес" to false,
        "Безопасность" to false,
        "Web" to true,
        "Девопс" to false,
        "Маркетинг" to false,
        "Аналитика" to false,
        "Data science" to false,
        "AI" to false,
        "UX/UI" to false,
        "Blockchain" to false,
        "Game development" to false,
        "Cybersecurity" to false,
        "Cloud computing" to false,
        "Machine learning" to false,
    )
    InterestsContent(
        interestsMap = interestsMap,
        saveButtonState = LoadingButtonState.ACTIVE,
        onSaveClick = { },
        onPostponeClick = { },
        onTagClick = { }
    )
}