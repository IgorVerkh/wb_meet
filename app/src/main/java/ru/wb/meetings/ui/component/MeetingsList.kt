package ru.wb.meetings.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.model.Meeting
import ru.wb.meetings.ui.theme.NeutralLine

@Composable
fun MeetingsList(
    meetings: List<Meeting>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(meetings) { meeting ->
            MeetingCard(meeting, isOver = true)
            HorizontalDivider(color = NeutralLine)
        }
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
private fun MeetingsListPreview() {
    MeetingsList(meetings)
}