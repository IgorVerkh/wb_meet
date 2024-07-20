package com.example.presentation.screen.all_meetings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.presentation.R
import com.example.presentation.component.AllMeetingsTopBar
import com.example.presentation.component.MeetingsBottomNavBar
import com.example.presentation.component.MeetingsList
import com.example.presentation.component.MeetingsTabRow
import com.example.presentation.component.SearchBar
import com.example.presentation.model.Meeting
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun AllMeetings(
    navController: NavHostController,
    viewModel: AllMeetingsViewModel = koinViewModel()
) {
    Scaffold(
        topBar = { AllMeetingsTopBar(modifier = Modifier.padding(start = 8.dp, end = 24.dp)) },
        bottomBar = { MeetingsBottomNavBar(navController = navController) }
    ) { innerPadding ->
        AllMeetingsContent(
            meetings = mock_meetings,
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
    meetings: List<Meeting>,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(value = "", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
        MeetingsTabRow(
            tabs = listOf("ВСЕ ВСТРЕЧИ", "АКТИВНЫЕ"),
            selectedTabIndex = selectedTabIndex,
            onTabClick = { index -> selectedTabIndex = index },
        )
        Spacer(modifier = Modifier.height(16.dp))
        // TODO: make a function to distinguish between all
        when (selectedTabIndex) {
            0 -> MeetingsList(meetings = meetings)
            1 -> MeetingsList(meetings = listOf())
        }
    }
}

private val mock_meetings = List(10) {
    Meeting(
        title = "Developer meeting",
        date = "13.09.2024",
        city = "Казань",
        image = R.drawable.ic_group_placeholder,
        tags = listOf("Python", "Junior"))
}

@Preview(showSystemUi = true)
@Composable
private fun AllMeetingsPreview() {
    AllMeetingsContent(
        meetings = mock_meetings
    )
}

@Preview(showSystemUi = true)
@Composable
private fun AllMeetingsWithScaffoldPreview() {
    Scaffold(
        bottomBar = { MeetingsBottomNavBar(navController = rememberNavController()) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            AllMeetingsTopBar(modifier = Modifier.padding(start = 8.dp, end = 24.dp))
            AllMeetingsContent(
                meetings = mock_meetings,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}