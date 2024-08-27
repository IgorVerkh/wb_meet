package com.example.presentation.screen.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.component.SocialChip
import com.example.presentation.component.SocialMedia

@Composable
internal fun SocialNetworks(
    socials: List<SocialMedia>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        socials.forEach {
            SocialChip(socialMedia = it)
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
private fun SocialNetworksPreview() {
    SocialNetworks(
        socials = listOf(SocialMedia.TWITTER, SocialMedia.FACEBOOK),
        modifier = Modifier
            .fillMaxWidth()
    )
}