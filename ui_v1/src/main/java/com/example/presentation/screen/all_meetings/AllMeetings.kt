package com.example.presentation.screen.all_meetings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.domain.model.Meeting
import com.example.presentation.R
import com.example.presentation.component.AllMeetingsTopBar
import com.example.presentation.component.MeetingsBottomNavBar
import com.example.presentation.component.MeetingsList
import com.example.presentation.component.MeetingsTabRow
import com.example.presentation.component.SearchBar
import com.example.presentation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

private enum class AllMeetingsTabs(val index: Int, val labelStringResource: Int) {
    ALL(0, R.string.all_meetings_tab),
    ACTIVE(1, R.string.active_meetings_tab)
}

private val tabs = listOf(AllMeetingsTabs.ALL, AllMeetingsTabs.ACTIVE)

@Composable
internal fun AllMeetings(
    navController: NavHostController,
    viewModel: AllMeetingsViewModel = koinViewModel()
) {
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    Scaffold(
        topBar = { AllMeetingsTopBar(modifier = Modifier.padding(start = 8.dp, end = 24.dp)) },
        bottomBar = { MeetingsBottomNavBar(navController = navController) }
    ) { innerPadding ->
        AllMeetingsContent(
            meetingsList = uiState.meetingsList,
            onMeetingClick = { id ->
                navController.navigate("${Screen.MeetingDetails.route}/$id") },
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                )
        )
    }
}

@Composable
private fun AllMeetingsContent(
    meetingsList: List<Meeting>,
    onMeetingClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(AllMeetingsTabs.ALL) }

    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(value = "", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
        MeetingsTabRow(
            tabs = tabs.map { stringResource(it.labelStringResource) },
            selectedTabIndex = selectedTab.index,
            onTabClick = { tabIndex ->
                selectedTab = tabs[tabIndex]
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        // TODO: make a function to distinguish between all and active
        when (selectedTab) {
            AllMeetingsTabs.ALL -> MeetingsList(
                meetingsList = meetingsList,
                onMeetingClick = onMeetingClick
            )
            AllMeetingsTabs.ACTIVE -> MeetingsList(
                meetingsList = listOf(),
                onMeetingClick = onMeetingClick
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AllMeetingsPreview() {

    val mock_meetings = List(10) {
        Meeting(
            id = 0,
            title = "Developer meeting",
            date = "13.09.2024",
            city = "Казань",
            image = null,
            tags = listOf("Python", "Junior")
        )
    }

    AllMeetingsContent(
        meetingsList = mock_meetings,
        onMeetingClick = { }
    )
}