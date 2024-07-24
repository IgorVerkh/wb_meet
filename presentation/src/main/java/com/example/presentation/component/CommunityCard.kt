package com.example.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.domain.model.Community
import com.example.domain.model.User
import com.example.presentation.R
import com.example.presentation.theme.Body1
import com.example.presentation.theme.Metadata1
import com.example.presentation.theme.NeutralLine
import com.example.presentation.theme.NeutralWeak

@Composable
fun CommunityCard(
    community: Community,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 4.dp)
    ) {
        Row {
            SquareAvatar(image = community.image, modifier = Modifier.size(size = 48.dp))
            Spacer(modifier = Modifier.width(14.dp))
            Column {
                Text(text = community.title, style = Body1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = stringResource(
                        R.string.community_card_attendees_postfix,
                        community.attendees.size
                    ),
                    modifier = Modifier.padding(vertical = 4.dp),
                    style = Metadata1,
                    color = NeutralWeak
                )
            }
        }
    }
}

@Composable
fun CommunityCardList(
    communities: List<Community>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(communities) { community ->
            CommunityCard(community, modifier = Modifier.padding(bottom = 16.dp))
            HorizontalDivider(color = NeutralLine)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CommunityCardPreview() {
    val community = Community(
        id = 0,
        title = "Designa",
        description = LoremIpsum(40).values.first(),
        image = R.drawable.ic_group_placeholder,
        meetings = listOf(),
        attendees = listOf(
            User(id = 0, avatar = null),
            User(id = 0, avatar = null)
        )
    )
    CommunityCard(community = community)
}