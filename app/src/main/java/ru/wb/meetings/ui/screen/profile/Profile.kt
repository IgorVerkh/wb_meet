package ru.wb.meetings.ui.screen.profile

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.R
import ru.wb.meetings.ui.component.MeetingsBottomNavBar
import ru.wb.meetings.ui.component.ProfileTopBar
import ru.wb.meetings.ui.component.RoundAvatar
import ru.wb.meetings.ui.component.SocialMedia
import ru.wb.meetings.ui.screen.profile.component.SocialNetworks
import ru.wb.meetings.ui.theme.Heading2
import ru.wb.meetings.ui.theme.NeutralActive
import ru.wb.meetings.ui.theme.NeutralDisabled
import ru.wb.meetings.ui.theme.Subheading2

@Composable
fun Profile(navController: NavHostController) {

    // место для ViewModel, стейта и коллбэков

    ProfileContent(
        navController = navController
    )
}

@Composable
private fun ProfileContent(
    navController: NavHostController
) {
    Scaffold(
        topBar = { ProfileTopBar(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) },
        bottomBar = { MeetingsBottomNavBar(navController = navController) }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
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
    }
}

@Preview
@Composable
private fun ProfileContentPreview() {
    ProfileContent(
        navController = rememberNavController()
    )
}