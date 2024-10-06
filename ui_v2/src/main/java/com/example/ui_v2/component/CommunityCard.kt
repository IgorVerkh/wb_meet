package com.example.ui_v2.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.model.CommunityCardData
import com.example.ui_v2.theme.MeetTheme
import com.example.ui_v2.theme.gradientSmoky

@Composable
internal fun CommunityCard(
    image: Any?,
    title: String,
    onCardClick: () -> Unit,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier,
    ) {
        SquareAvatar(image = image, modifier = Modifier
            .size(104.dp)
            .clickable { onCardClick() })
        Text(
            text = title,
            style = MeetTheme.typo.labelMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
        SubscribeCardButton(onClick = onButtonClick, modifier = Modifier.width(104.dp))
    }
}

@Composable
internal fun CommunitiesRow(
    communitiesList: List<CommunityCardData>,
    onCardClick: (Int) -> Unit,
    onButtonClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier,
    ) {
        items(communitiesList) { community ->
            CommunityCard(
                image = community.image,
                title = community.title,
                onCardClick = { onCardClick(community.id) },
                onButtonClick = { onButtonClick(community.id) })
        }
    }
}

@Composable
internal fun SubscribeCardButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(38.dp)
            .clip(RoundedCornerShape(size = 12.dp))
            .background(gradientSmoky)
            .clickable { onClick() },
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_plus),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun CommunityCardPreview() {
    CommunityCard(
        image = null,
        title = "Супер тестировщики",
        onCardClick = { },
        onButtonClick = { },
        modifier = Modifier.width(104.dp)
    )
}

@Preview
@Composable
private fun CommunitiesRowPreview() {
    val communities = List(10) {
        CommunityCardData(0, "Test community", null)
    }

    CommunitiesRow(communitiesList = communities, onCardClick = { }, onButtonClick = { })
}