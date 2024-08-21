package com.example.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import coil.compose.AsyncImage
import com.example.presentation.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCard(
    title: String,
    image: Any?,
    date: String,
    address: String,
    tags: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_event_test_image),
            modifier = Modifier.clip(
                RoundedCornerShape(16.dp)
            )
        )
        Text(text = title)
        FlowRow {
            Text(text = date)
            Text(text = address)
        }
        FlowRow {
            tags.forEach { TagChip(text = it) }
        }
    }
}

@Preview(showSystemUi = true, backgroundColor = 0xFF673AB7, showBackground = true)
@Composable
private fun EventCardPreview() {
    EventCard(
        title = "Python Days",
        image = R.drawable.ic_event_test_image,
        date = "10 августа",
        address = "Кожевенная линия, 40",
        tags = listOf("Тестирование", "Тестирование", "Тестирование"),
        modifier = Modifier.padding(all = 16.dp)
    )
}