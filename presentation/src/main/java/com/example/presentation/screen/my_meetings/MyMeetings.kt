package com.example.presentation.screen.my_meetings

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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.domain.model.Meeting
import com.example.presentation.R
import com.example.presentation.component.MeetingsBottomNavBar
import com.example.presentation.component.MeetingsList
import com.example.presentation.component.MeetingsTabRow
import com.example.presentation.component.MyMeetingsTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MyMeetings(
    navController: NavHostController,
    viewModel: MyMeetingsViewModel = koinViewModel()
) {
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()
    // TODO: rework with vm
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = { MyMeetingsTopBar(modifier = Modifier.padding(start = 20.dp, end = 24.dp)) },
        bottomBar = { MeetingsBottomNavBar(navController = navController) }
    ) { innerPadding ->
        MyMeetingsContent(
            meetingsList = uiState.meetings,
            selectedTabIndex = selectedTabIndex,
            onTabClick = { selectedTabIndex = it },
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
private fun MyMeetingsContent(
    meetingsList: List<Meeting>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        MeetingsTabRow(
            tabs = listOf("ЗАПЛАНИРОВАНО", "УЖЕ ПРОШЛИ"),
            selectedTab = selectedTabIndex,
            onTabClick = { index -> onTabClick(index) },
            modifier = Modifier.padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        when (selectedTabIndex) {
            0 -> MeetingsList(meetingsList = meetingsList)
            1 -> MeetingsList(meetingsList = meetingsList)
        }
    }
}
