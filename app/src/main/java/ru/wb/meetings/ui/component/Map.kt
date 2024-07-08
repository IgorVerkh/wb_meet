package ru.wb.meetings.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import ru.wb.meetings.R

@Composable
fun Map(
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    var showFullScreenImage by remember { mutableStateOf(false) }

    if (showFullScreenImage) {
        Dialog(onDismissRequest = { showFullScreenImage = false },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = { showFullScreenImage = false }
                )
            ) {
                AsyncImage(
                    model = R.drawable.ic_map_mock,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_map_mock),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }

    AsyncImage(
        model = R.drawable.ic_map_mock,
        contentDescription = null,
        placeholder = painterResource(id = R.drawable.ic_map_mock),
        contentScale = ContentScale.FillWidth,
        modifier = modifier
            .aspectRatio(16f/9f)
            .clip(shape = RoundedCornerShape(32.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { showFullScreenImage = true }
            )
    )
}



@Preview(showSystemUi = true)
@Composable
private fun MapPreview() {
    Map(modifier = Modifier.padding(all = 16.dp))
}