package ru.wb.meetings.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.ui.navigation.Screen
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.Body1
import ru.wb.meetings.ui.theme.NeutralActive

sealed class BottomNavItem(val screen: Screen, val selectedText: String, val unselectedIcon: Int) {
    data object Meetings : BottomNavItem(Screen.AllMeetings, "Встречи", R.drawable.ic_meetings)
    data object Communities : BottomNavItem(Screen.UiKit, "Сообщества", R.drawable.ic_communities)
    data object More : BottomNavItem(Screen.Profile, "Еще", R.drawable.ic_more)
}

val items = listOf(
    BottomNavItem.Meetings,
    BottomNavItem.Communities,
    BottomNavItem.More
)

@Composable
fun MeetingsBottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    elevation: Dp = 24.dp
) {
    NavigationBar(
        modifier = modifier
            .shadow(
                elevation = elevation,
                spotColor = Black
            ),
        containerColor = White
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { destination ->
            MeetingsNavBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == destination.screen.route } == true,
                onClick = {
                    navController.navigate(destination.screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                selectedIcon = {
                    SelectedNavBarItem(
                        label = destination.selectedText
                    )
                },
                unselectedIcon = {
                    Icon(
                        painter = painterResource(id = destination.unselectedIcon),
                        contentDescription = null)
                }
            )
        }
    }
}

@Composable
fun MeetingsBottomNavBar(
    selectedScreen: String,
    onScreenClick: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
            .shadow(
                elevation = 24.dp,
                spotColor = Black
            ),
        containerColor = White
    ) {
        items.forEach { destination ->
            MeetingsNavBarItem(
                selected = destination.screen.route == selectedScreen,
                onClick = { onScreenClick(destination) },
                selectedIcon = {
                    SelectedNavBarItem(
                        label = destination.selectedText,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                },
                unselectedIcon = {
                    Icon(
                        painter = painterResource(id = destination.unselectedIcon),
                        contentDescription = null
                    )
                }
            )
        }
    }
}

@Composable
private fun SelectedNavBarItem(
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = label, style = Body1, color = NeutralActive)
        Canvas(modifier = modifier) {
            drawCircle(
                color = NeutralActive,
                radius = 3.dp.toPx(),
                center = Offset(x = 0.dp.toPx(), y = 12.dp.toPx()),
                style = Fill
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavBarPreview() {
    MeetingsBottomNavBar(
        navController = rememberNavController()
    )
}