package ru.wb.meetings.ui.screen.community_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.wb.meetings.R
import ru.wb.meetings.ui.component.CommunityTopBar
import ru.wb.meetings.ui.component.MeetingsBottomNavBar
import ru.wb.meetings.ui.component.MeetingsList
import ru.wb.meetings.ui.model.Meeting
import ru.wb.meetings.ui.theme.Body1
import ru.wb.meetings.ui.theme.Metadata1
import ru.wb.meetings.ui.theme.NeutralWeak

@Composable
fun CommunityDetails(navController: NavHostController) {

}

@Composable
private fun CommunityDetailsContent(
    meetings: List<Meeting>
) {
    Column {
        Text(
            text = LoremIpsum(100).values.first(),
            style = Metadata1,
            color = NeutralWeak
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Встречи сообщества",
            style = Body1,
            color = NeutralWeak
        )
        Spacer(modifier = Modifier.height(16.dp))
        MeetingsList(meetings = meetings)
    }
}

private val meetings = listOf(
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
        tags = listOf("Junior", "Moscow"))
)

@Preview(showSystemUi = true)
@Composable
private fun CommunityDetailsPreview() {
    CommunityDetailsContent(meetings = meetings)
}

@Preview(showSystemUi = true)
@Composable
private fun CommunityDetailsWithScaffoldPreview() {
    Scaffold(
        topBar = { CommunityTopBar(
            label = "Designa",
            modifier = Modifier.padding(start = 8.dp, end = 24.dp)
        ) },
        bottomBar = { MeetingsBottomNavBar(
            selectedScreen = "",
            onScreenClick = {}
        ) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            CommunityDetailsContent(meetings = meetings)
        }
    }
}