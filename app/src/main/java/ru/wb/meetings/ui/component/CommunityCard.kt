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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.Body1
import ru.wb.meetings.ui.theme.Metadata1
import ru.wb.meetings.ui.theme.NeutralWeak

@Composable
fun CommunityCard(
    title: String,
    image: Any?,
    peopleCount: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 4.dp)
    ) {
        Row {
            SquareAvatar(image = image, modifier = Modifier.size(size = 48.dp))
            Spacer(modifier = Modifier.width(14.dp))
            Column {
                Text(text = title, style = Body1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "$peopleCount человек",
                    modifier = Modifier.padding(vertical = 4.dp),
                    style = Metadata1,
                    color = NeutralWeak
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommunityCardPreview() {
    CommunityCard(
        title = "Designa",
        image = R.drawable.ic_group_placeholder,
        peopleCount = 10000
    )
}