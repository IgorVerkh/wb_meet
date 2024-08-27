package com.example.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.theme.Body2
import com.example.presentation.theme.BrandBackground
import com.example.presentation.theme.BrandDark
import com.example.presentation.theme.BrandDefault
import com.example.presentation.theme.MeetTheme
import com.example.presentation.theme.Metadata3

enum class SocialMedia(val iconResource: Int) {
    INSTAGRAM(R.drawable.ic_instagram),
    FACEBOOK(R.drawable.ic_facebook),
    TWITTER(R.drawable.ic_twitter),
    LINKEDIN(R.drawable.ic_linkedin)
}

@Composable
fun TagChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .background(
                color = MeetTheme.colors.disabled,
                shape = RoundedCornerShape(48.dp)
            )
            .padding(horizontal = 10.dp, vertical = 4.dp),
        style = Body2,
        color = MeetTheme.colors.primary,
        text = text
    )
}

@Composable
fun TagChipRow(
    tags: List<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        tags.forEach { tag ->
            TagChip(text = tag)
        }
    }
}

@Composable
fun SocialChip(
    socialMedia: SocialMedia,
    modifier: Modifier = Modifier,
    color: Color = BrandDefault
) {
    Box(
        modifier = modifier
            .size(width = 70.dp, height = 40.dp)
            .border(width = 2.dp, color = color, shape = RoundedCornerShape(25.dp))

    ) {
        Icon(
            painter = painterResource(id = socialMedia.iconResource),
            contentDescription = null,
            tint = color,
            modifier = Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
private fun TagChipPreview() {
    MeetTheme {
        TagChip(text = "Python")
    }
}

@Preview
@Composable
private fun TagChipRowPreview() {
    TagChipRow(
        tags = listOf("Python", "Junior", "Moscow")
    )
}

@Preview
@Composable
private fun SocialPreview() {
    MeetTheme {
        Row {
            SocialChip(
                SocialMedia.TWITTER
            )
            SocialChip(
                SocialMedia.INSTAGRAM
            )
            SocialChip(
                SocialMedia.LINKEDIN
            )
            SocialChip(
                SocialMedia.FACEBOOK
            )
        }
    }
}