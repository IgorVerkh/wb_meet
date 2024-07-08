package ru.wb.meetings.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.model.Meeting
import ru.wb.meetings.ui.theme.Body1
import ru.wb.meetings.ui.theme.Metadata1
import ru.wb.meetings.ui.theme.Metadata2
import ru.wb.meetings.ui.theme.NeutralWeak

@Composable
fun MeetingCard(
    meeting: Meeting,
    isOver: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 4.dp)
    ) {
        Row {
            SquareAvatar(image = meeting.image, modifier = Modifier.size(size = 48.dp))
            Spacer(modifier = Modifier.width(14.dp))
            Column {
                Text(
                    text = meeting.title,
                    style = Body1,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth(0.7f),
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${meeting.date} — ${meeting.city}",
                    modifier = Modifier.padding(vertical = 4.dp),
                    style = Metadata1,
                    color = NeutralWeak)
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    meeting.tags.forEach {
                        TagChip(text = it)
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            if (isOver) {
                Text(text = "Закончилась", style = Metadata2, color = NeutralWeak)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun MeetingCardPreview() {
    Column {
        MeetingCard(
            meeting = Meeting(
                title = "Developer meeting",
                date = "13.09.2024",
                city = "Казань",
                image = R.drawable.ic_group_placeholder,
                tags = listOf("Python", "Junior")),
            isOver = true
        )
    }
}