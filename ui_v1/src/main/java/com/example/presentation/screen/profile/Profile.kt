package com.example.presentation.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.presentation.R
import com.example.presentation.component.MeetingsBottomNavBar
import com.example.presentation.component.ProfileTopBar
import com.example.presentation.component.RoundAvatar
import com.example.presentation.component.SocialMedia
import com.example.presentation.screen.profile.component.SocialNetworks
import com.example.presentation.theme.Heading2
import com.example.presentation.theme.NeutralActive
import com.example.presentation.theme.NeutralDisabled
import com.example.presentation.theme.Subheading2
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun Profile(
    navController: NavHostController,
    viewModel: ProfileViewModel = koinViewModel()
) {

    // место для ViewModel, стейта и коллбэков

    Scaffold(
        topBar = { ProfileTopBar(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) },
        bottomBar = { MeetingsBottomNavBar(navController = navController) }
    ) { innerPadding ->
        ProfileContent(
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                )
        )
    }
}

@Composable
private fun ProfileContent(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center)
            .fillMaxHeight(0.8f)
    ) {
        RoundAvatar(
            image = R.drawable.ic_avatar_placeholder,
            modifier = Modifier.size(size = 200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Иван Иванов", style = Heading2, color = NeutralActive)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "+7 999 999-99-99", style = Subheading2, color = NeutralDisabled)
        Spacer(modifier = Modifier.height(32.dp))
        SocialNetworks(
            socials = listOf(
                SocialMedia.TWITTER,
                SocialMedia.INSTAGRAM,
                SocialMedia.LINKEDIN,
                SocialMedia.FACEBOOK),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ProfileContentPreview() {
    ProfileContent()
}