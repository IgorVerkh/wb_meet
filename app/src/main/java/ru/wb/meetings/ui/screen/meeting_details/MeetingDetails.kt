package ru.wb.meetings.ui.screen.meeting_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import ru.wb.meetings.R
import ru.wb.meetings.ui.component.BottomNavItem
import ru.wb.meetings.ui.component.Map
import ru.wb.meetings.ui.component.MeetButton
import ru.wb.meetings.ui.component.MeetingTopBar
import ru.wb.meetings.ui.component.MeetingsBottomNavBar
import ru.wb.meetings.ui.component.MembersRow
import ru.wb.meetings.ui.component.TagChipRow
import ru.wb.meetings.ui.theme.Body1
import ru.wb.meetings.ui.theme.Metadata1
import ru.wb.meetings.ui.theme.NeutralWeak

@Composable
fun MeetingDetails(
    navController: NavHostController,
    viewModel: MeetingDetailsViewModel = koinViewModel()
) {

    Scaffold(
        topBar = { MeetingTopBar(
            label = "Developer Meeting",
            modifier = Modifier.padding(start = 8.dp, end = 24.dp)
        ) },
        bottomBar = { MeetingsBottomNavBar(navController = navController) }
    ) { innerPadding ->
        MeetingDetailsContent(
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
private fun MeetingDetailsContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "13.09.2024 — Москва, ул. Громова, 4",
            style = Body1,
            color = NeutralWeak
        )
        Spacer(modifier = Modifier.height(8.dp))
        TagChipRow(
            tags = listOf("Python", "Junior", "Moscow"),
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Map()
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = LoremIpsum(40).values.first(),
            style = Metadata1,
            color = NeutralWeak
        )
        Spacer(modifier = Modifier.height(24.dp))
        MembersRow(members = listOf(
            R.drawable.ic_group_placeholder,
            R.drawable.ic_group_placeholder,
            R.drawable.ic_group_placeholder,))
        Spacer(modifier = Modifier.height(24.dp))
        MeetButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Пойду на встречу!")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MeetingDetailsPreview() {
    MeetingDetailsContent()
}

@Preview(showSystemUi = true)
@Composable
private fun MeetingDetailsWithScaffoldPreview() {
    Scaffold(
        topBar = { MeetingTopBar(
            label = "Developer Meeting",
            modifier = Modifier.padding(start = 8.dp, end = 24.dp)
        ) },
        bottomBar = { MeetingsBottomNavBar(
            selectedScreen = BottomNavItem.Meetings,
            onScreenClick = {}
        ) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            MeetingDetailsContent()
        }
    }
}