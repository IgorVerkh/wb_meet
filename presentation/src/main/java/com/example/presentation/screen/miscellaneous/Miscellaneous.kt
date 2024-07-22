package com.example.presentation.screen.miscellaneous

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.presentation.R
import com.example.presentation.component.BottomNavItem
import com.example.presentation.component.MeetingsBottomNavBar
import com.example.presentation.component.MiscMenuItem
import com.example.presentation.component.RoundAvatar
import com.example.presentation.component.WbTopBar
import com.example.presentation.navigation.Screen
import com.example.presentation.theme.Body1
import com.example.presentation.theme.NeutralDisabled
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun Miscellaneous(
    navController: NavHostController,
    viewModel: MiscellaneousViewModel = koinViewModel()
) {

    Scaffold(
        topBar = { WbTopBar(text = "Еще", modifier = Modifier.padding(start = 8.dp, end = 24.dp)) },
        bottomBar = { MeetingsBottomNavBar(navController = navController) }
    ) { innerPadding ->
        MiscellaneousContent(
            onProfileClick = { navController.navigate(Screen.Profile.route) },
            onMyMeetingsClick = { navController.navigate(Screen.MyMeetings.route) },
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
private fun MiscellaneousContent(
    onProfileClick: () -> Unit,
    onMyMeetingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        MiscMenuItem(
            text = {
                Column {
                    Spacer(modifier = Modifier.weight(0.3f))
                    Text(text = "Иван Иванов", style = Body1)
                    Spacer(modifier = Modifier.weight(0.4f))
                    Text(text = "+7 999 999-99-99", style = Body1, color = NeutralDisabled)
                    Spacer(modifier = Modifier.weight(0.3f))
                }
            },
            leadingIcon = {
                RoundAvatar(image = null, modifier = Modifier.size(50.dp))
            },
            onClick = { onProfileClick() },
            modifier = Modifier.height(66.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        MiscMenuItem(
            text = "Мои встречи",
            leadingIcon = R.drawable.ic_meetings,
            onClick = { onMyMeetingsClick() }
        )
        Spacer(modifier = Modifier.height(8.dp))
        MiscMenuItem(
            text = "Тема",
            leadingIcon = R.drawable.ic_sun,
            onClick = { /*TODO*/ })
        MiscMenuItem(
            text = "Уведомления",
            leadingIcon = R.drawable.ic_notifications,
            onClick = { /*TODO*/ })
        MiscMenuItem(
            text = "Безопасность",
            leadingIcon = R.drawable.ic_security,
            onClick = { /*TODO*/ })
        MiscMenuItem(
            text = "Память и ресурсы",
            leadingIcon = R.drawable.ic_files,
            onClick = { /*TODO*/ })
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        MiscMenuItem(
            text = "Помощь",
            leadingIcon = R.drawable.ic_help,
            onClick = { /*TODO*/ })
        MiscMenuItem(
            text = "Пригласи друга",
            leadingIcon = R.drawable.ic_letter,
            onClick = { /*TODO*/ })
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MiscellaneousWithScaffoldPreview() {
    Scaffold(
        topBar = { WbTopBar(text = "Еще", modifier = Modifier.padding(start = 8.dp, end = 24.dp)) },
        bottomBar = { MeetingsBottomNavBar(
            selectedScreen = BottomNavItem.Mics,
            onScreenClick = {}
        ) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            MiscellaneousContent(
                onProfileClick = {},
                onMyMeetingsClick = {}
            )
        }
    }
}