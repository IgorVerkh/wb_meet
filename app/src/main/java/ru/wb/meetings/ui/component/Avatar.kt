package ru.wb.meetings.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.AvatarBorder

@Composable
fun SquareAvatar(
    image: Any?,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = image,
        contentDescription = null,
        placeholder = painterResource(id = R.drawable.ic_group_placeholder),
        modifier = modifier
            .defaultMinSize(minHeight = 48.dp, minWidth = 48.dp)
            .clip(RoundedCornerShape(size = 16.dp))
        )
}

@Composable
fun BorderedSquareAvatar(
    image: Any?,
    modifier: Modifier = Modifier
) {
    SquareAvatar(
        image = image,
        modifier = modifier
            .border(width = 2.dp, color = AvatarBorder, shape = RoundedCornerShape(16.dp))
    )
}

@Composable
fun RoundAvatar(
    image: Any?,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = image,
        contentDescription = null,
        placeholder = painterResource(id = R.drawable.ic_avatar_placeholder),
        modifier = modifier
            .clip(CircleShape)
    )
}

@Composable
fun RoundAvatarEdit(
    image: Any?,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        val badgeSize = maxWidth * 0.2f
        val badgeOffset = maxWidth * 0.05f

        RoundAvatar(image = image, modifier = Modifier.fillMaxSize())
        Image(
            painter = painterResource(R.drawable.ic_add_badge),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-badgeOffset.value).dp, y = (-badgeOffset.value).dp)
                .size(size = badgeSize)
        )
    }
}

@Preview
@Composable
private fun SquareAvatarPreview() {
    SquareAvatar(
        image = R.drawable.ic_group_placeholder
    )
}

@Preview
@Composable
private fun BorderedSquareAvatarPreview() {
    BorderedSquareAvatar(
        image = R.drawable.ic_group_placeholder
    )
}

@Preview(showBackground = false)
@Composable
private fun RoundAvatarPreview() {
    RoundAvatar(image = null, modifier = Modifier.size(size = 50.dp))
}

@Preview(showBackground = true, backgroundColor = 0xFFCDDC39)
@Composable
private fun RoundAvatarEditPreview() {
    Column {
        RoundAvatarEdit(image = null, modifier = Modifier.size(size = 100.dp))
        Spacer(modifier = Modifier.height(16.dp))
        RoundAvatarEdit(image = null, modifier = Modifier.size(size = 200.dp))
        Spacer(modifier = Modifier.height(16.dp))
        RoundAvatarEdit(image = null, modifier = Modifier.size(size = 400.dp))
    }
}