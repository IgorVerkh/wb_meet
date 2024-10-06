package com.example.ui_v2.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui_v2.R

@Composable
internal fun SquareAvatar(
    image: Any?,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = image,
        contentDescription = null,
        placeholder = painterResource(R.drawable.ic_community_test),
        contentScale = ContentScale.Crop,
        modifier = modifier.aspectRatio(1f).clip(RoundedCornerShape(size = 16.dp))
    )
}

@Composable
internal fun RoundAvatar(
    image: Any?,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = image,
        contentDescription = null,
        placeholder = painterResource(R.drawable.ic_community_test),
        contentScale = ContentScale.Crop,
        modifier = modifier.aspectRatio(1f).clip(CircleShape)
    )
}

@Preview
@Composable
private fun SquareAvatarPreview() {
    SquareAvatar(image = null, modifier = Modifier.size(size = 166.dp))
}

@Preview
@Composable
private fun RoundAvatarPreview() {
    RoundAvatar(image = null, modifier = Modifier.size(size = 104.dp))
}