package com.example.ui_v2.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui_v2.R
import com.example.ui_v2.model.EventCardData
import com.example.ui_v2.theme.MeetTheme

@Composable
internal fun EventCardWide(
    title: String,
    image: Any?,
    date: String,
    address: String,
    tags: List<String>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    EventCard(
        title = { Text(text = title, style = MeetTheme.typo.displayLarge, color = Color.Black) },
        image = image,
        date = date,
        address = address,
        tags = tags,
        onClick = onClick,
        modifier = modifier
    )
}

@Composable
internal fun EventCardThin(
    title: String,
    image: Any?,
    date: String,
    address: String,
    tags: List<String>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    EventCard(
        title = { Text(text = title, style = MeetTheme.typo.displayMedium, color = Color.Black) },
        image = image,
        date = date,
        address = address,
        tags = tags,
        onClick = onClick,
        modifier = modifier
    )
}

@Composable
internal fun WideEventsRow(
    eventsList: List<EventCardData>,
    onEventClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ) {
        items(eventsList) { event ->
            EventCardWide(
                title = event.title,
                image = event.image,
                date = event.date,
                address = event.address,
                tags = event.tags,
                onClick = { onEventClick(event.id) },
                modifier = Modifier
                    .width(320.dp)
            )
        }
    }
}

@Composable
internal fun ThinEventsRow(
    eventsList: List<EventCardData>,
    onEventClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ) {
        items(eventsList) { event ->
            EventCardThin(
                title = event.title,
                image = event.image,
                date = event.date,
                address = event.address,
                tags = event.tags,
                onClick = { onEventClick(event.id) },
                modifier = Modifier
                    .width(212.dp)
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCard(
    title: @Composable () -> Unit,
    image: Any?,
    date: String,
    address: String,
    tags: List<String>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.clickable { onClick() }
    ) {
        val overflow = ContextualFlowRowOverflow.expandIndicator {
            MediumTag(
                text = "+${tags.size - this.shownItemCount}",
                state = TagState.SECONDARY,
                onClick = {},
                enabled = false
            )
        }

        AsyncImage(
            model = image,
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_event_test_image),
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .defaultMinSize(minWidth = 320.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        title()
        Text(
            text = "$date · $address",
            style = MeetTheme.typo.bodyMedium,
            color = MeetTheme.colors.metadata,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(end = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        ContextualFlowRow(
            itemCount = tags.size,
            maxLines = 1,
            overflow = overflow,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            tags.forEach {
                MediumTag(
                    text = it,
                    state = TagState.SECONDARY,
                    onClick = {},
                    enabled = false
                )
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun EventCardWidePreview() {
    EventCardWide(
        title = "Python Days",
        image = R.drawable.ic_event_test_image,
        date = "10 августа",
        address = "Кожевенная линия, 40",
        tags = List(15) { "Тестирование" },
        onClick = { },
        modifier = Modifier
            .width(320.dp)
    )
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun EventCardThinPreview() {
    EventCardThin(
        title = "Python Days",
        image = R.drawable.ic_event_test_image,
        date = "10 августа",
        address = "Кожевенная линия, 40",
        tags = List(15) { "Тестирование" },
        onClick = { },
        modifier = Modifier
            .width(212.dp)
    )
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun EventCardRailPreview() {
    val events = List(10) {
        EventCardData(
            id = 0,
            title = "Python Days",
            image = R.drawable.ic_event_test_image,
            date = "10 августа",
            address = "Кожевенная линия, 40",
            tags = List(15) { "Тестирование" },
        )
    }

    Column {
        WideEventsRow(eventsList = events, onEventClick = { })
        Spacer(modifier = Modifier.height(64.dp))
        ThinEventsRow(eventsList = events, onEventClick = { })
    }

}