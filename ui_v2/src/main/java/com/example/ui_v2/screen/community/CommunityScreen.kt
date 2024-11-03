package com.example.ui_v2.screen.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v2.component.WBAppBar

@Composable
internal fun CommunityScreen() {

}

@Composable
private fun CommunityContent(
    title: String,
) {
    val paddingValues = WindowInsets.navigationBars.asPaddingValues()

    Column(
        modifier = Modifier
            .padding(
                start = 12.dp,
                end = 12.dp,
                bottom = 28.dp + paddingValues.calculateBottomPadding()
            )
    ) {
        WBAppBar(title = title)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CommunityPreview() {
    CommunityContent(
        title = "The IT Crowd"
    )
}