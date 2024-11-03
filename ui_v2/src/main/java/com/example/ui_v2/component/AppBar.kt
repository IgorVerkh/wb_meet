package com.example.ui_v2.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui_v2.R
import com.example.ui_v2.theme.MeetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun WBAppBar(
    title: String,
    modifier: Modifier = Modifier,
    isShareActive: Boolean = true,
    onBackClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
) {
    val shareIcon = @Composable {
        Image(
            painter = painterResource(id = R.drawable.ic_share),
            contentDescription = null,
        )
    }

    TopAppBar(
        title = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = MeetTheme.typo.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                )
            }
        },
        actions = {
            if (isShareActive) {
                IconButton(onClick = onShareClick) {
                    shareIcon()
                }
            }
        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun WBAppBarPreview() {
    WBAppBar(
        title = "It crowd",
        isShareActive = true
    )
}