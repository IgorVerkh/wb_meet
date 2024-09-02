package com.example.ui_v2.screen.interests

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ui_v2.R
import com.example.ui_v2.component.BigTag
import com.example.ui_v2.component.LoadingButton
import com.example.ui_v2.component.LoadingButtonState
import com.example.ui_v2.component.TagState
import com.example.ui_v2.theme.MeetTheme

@Composable
internal fun InterestsScreen(
    navController: NavHostController,
) {

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun InterestsContent(
    interestsMap: Map<String, Boolean>,
    saveButtonState: LoadingButtonState,
) {
    Column(
        modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 28.dp)
    ) {
        Text(stringResource(R.string.interests_title), style = MeetTheme.typo.displayLarge)
        Spacer(modifier = Modifier.height(12.dp))
        Text(stringResource(R.string.interests_description), style = MeetTheme.typo.titleMedium)
        Spacer(modifier = Modifier.height(24.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            interestsMap.forEach { (label, isActive) ->
                BigTag(
                    text = label,
                    onClick = { /*TODO*/ },
                    state = if (isActive) TagState.ACTIVE else TagState.SECONDARY,
                    enabled = true
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        LoadingButton(
            text = "Сохранить",
            onClick = { /*TODO*/ },
            loadingButtonState = saveButtonState,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Расскажу позже", style = MeetTheme.typo.bodyLarge)
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
    )
    InterestsContent(
        interestsMap = interestsMap,
        saveButtonState = LoadingButtonState.ACTIVE
    )
}