package ru.wb.meetings.ui.screen.all_meetings

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
import ru.wb.meetings.R
import ru.wb.meetings.ui.component.AllMeetingsTopBar
import ru.wb.meetings.ui.component.MeetingsBottomNavBar
import ru.wb.meetings.ui.component.MeetingsList
import ru.wb.meetings.ui.component.MeetingsTabRow
import ru.wb.meetings.ui.component.SearchBar
import ru.wb.meetings.ui.model.Meeting

@Composable
fun AllMeetings(navController: NavHostController) {

    // TODO: Rework with VM
    val meetings = listOf(
        Meeting(
            title = "Developer meeting",
            date = "13.09.2024",
            city = "Казань",
            image = R.drawable.ic_group_placeholder,
            tags = listOf("Python", "Junior")),
        Meeting(
            title = "Developer meeting Developer meeting Developer meeting Developer meeting Developer meeting",
            date = "13.09.2024",
            city = "NY",
            image = R.drawable.ic_group_placeholder,
            tags = listOf("Junior", "Moscow")),
        Meeting(
            title = "Developer meeting",
            date = "14.09.2024",
            city = "Москва",
            image = R.drawable.ic_group_placeholder,
            tags = listOf("Junior", "Moscow"))
        )

    AllMeetingsContent(
        meetings = meetings,
        navController = navController
    )
}

@Composable
private fun AllMeetingsContent(
    meetings: List<Meeting>,
    navController: NavHostController
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = { AllMeetingsTopBar(modifier = Modifier.padding(start = 8.dp, end = 24.dp)) },
        bottomBar = { MeetingsBottomNavBar(navController = navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar(text = "", onValueChange = {})
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
}

@Preview
@Composable
private fun AllMeetingsPreview() {
    val meetings = listOf(
        Meeting(
            title = "Developer meeting",
            date = "13.09.2024",
            city = "Казань",
            image = R.drawable.ic_group_placeholder,
            tags = listOf("Python", "Junior")),
        Meeting(
            title = "Developer meeting Developer meeting Developer meeting Developer meeting Developer meeting",
            date = "13.09.2024",
            city = "NY",
            image = R.drawable.ic_group_placeholder,
            tags = listOf()),
        Meeting(
            title = "Developer meeting",
            date = "14.09.2024",
            city = "Москва",
            image = R.drawable.ic_group_placeholder,
            tags = listOf("Junior", "Moscow")),
        Meeting(
            title = "Developer meeting",
            date = "13.09.2024",
            city = "Казань",
            image = R.drawable.ic_group_placeholder,
            tags = listOf("Python", "Junior")),
        Meeting(
            title = "Developer meeting",
            date = "13.09.2024",
            city = "Казань",
            image = R.drawable.ic_group_placeholder,
            tags = listOf("Python", "Junior")),
        Meeting(
            title = "Developer meeting",
            date = "13.09.2024",
            city = "Казань",
            image = R.drawable.ic_group_placeholder,
            tags = listOf("Python", "Junior")),
        Meeting(
            title = "Developer meeting",
            date = "13.09.2024",
            city = "Казань",
            image = R.drawable.ic_group_placeholder,
            tags = listOf("Python", "Junior")),
    )
    AllMeetingsContent(
        meetings = meetings,
        navController = rememberNavController()
    )
}