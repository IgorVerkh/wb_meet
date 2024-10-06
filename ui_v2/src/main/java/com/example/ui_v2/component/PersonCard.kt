package com.example.ui_v2.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui_v2.R
import com.example.ui_v2.theme.MeetTheme

@Composable
internal fun PersonCard(
    avatar: Any?,
    name: String,
    tag: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
            .clickable { onClick() },
    ) {
        // Avatar
        AsyncImage(
            model = avatar,
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_avatar_test),
            error = painterResource(R.drawable.ic_avatar_test),
            modifier = Modifier
                .size(104.dp)
                .clip(shape = CircleShape)
        )
        // Name
        Text(text = name, style = MeetTheme.typo.titleSmall)
        // Specialty
        SmallTag(
            text = tag,
            onClick = { /*TODO*/ },
            state = TagState.SECONDARY,
            enabled = false
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PersonCardPreview() {
    PersonCard(
        avatar = null,
        name = "Igor",
        tag = "Android",
        onClick = { },
        modifier = Modifier,
    )
}