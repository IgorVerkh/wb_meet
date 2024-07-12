package ru.wb.meetings.ui.screen.communities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.wb.meetings.R
import ru.wb.meetings.ui.component.AllCommunitiesTopBar
import ru.wb.meetings.ui.component.CommunityCardList
import ru.wb.meetings.ui.component.MeetingsBottomNavBar
import ru.wb.meetings.ui.component.SearchBar
import ru.wb.meetings.ui.model.Community

@Composable
fun Communities(navController: NavHostController) {

}

@Composable
private fun CommunitiesContent(
    communities: List<Community>
) {
    Column {
        SearchBar(value = "", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
        CommunityCardList(communities = communities)
    }
}

private val communities = listOf(
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
    Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000),
)

@Preview(showSystemUi = true)
@Composable
private fun CommunitiesPreview() {
    CommunitiesContent(communities = communities)
}

@Preview(showSystemUi = true)
@Composable
private fun CommunitiesWithScaffoldPreview() {
    Scaffold(
        topBar = { AllCommunitiesTopBar(modifier = Modifier.padding(start = 8.dp, end = 24.dp)) },
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
            CommunitiesContent(communities = communities)
        }
    }
}