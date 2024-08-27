package com.example.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.model.Meeting
import com.example.presentation.theme.NeutralLine

@Composable
internal fun MeetingsList(
    meetingsList: List<Meeting>,
    onMeetingClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(meetingsList) { meeting ->
            MeetingCard(
                meeting,
                isOver = true,
                onClick = { onMeetingClick(meeting.id) }
            )
            HorizontalDivider(color = NeutralLine)
        }
    }
}