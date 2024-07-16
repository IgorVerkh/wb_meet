package ru.wb.meetings.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import ru.wb.meetings.R
import ru.wb.meetings.ui.navigation.Graph
import ru.wb.meetings.ui.theme.Body1
import ru.wb.meetings.ui.theme.NeutralActive

sealed class BottomNavItem(
    val graph: Graph,
    val selectedText: String,
    val unselectedIcon: Int
) {
    data object Meetings : BottomNavItem(Graph.MeetingsGraph, "Встречи", R.drawable.ic_meetings)
    data object Communities : BottomNavItem(Graph.CommunitiesGraph, "Сообщества", R.drawable.ic_communities)
    data object Mics : BottomNavItem(Graph.MiscGraph, "Еще", R.drawable.ic_more)
}

private val items = listOf(
    BottomNavItem.Meetings,
    BottomNavItem.Communities,
    BottomNavItem.Mics
)

@Composable
fun MeetingsBottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = White
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { destination ->
            MeetingsNavBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == destination.graph.route } == true,
                onClick = {
                    currentDestination?.let {
                        navController.navigate(destination.graph.route) {
                            popUpTo(it.id) { inclusive = true }
                        }
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
    selectedScreen: BottomNavItem,
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
                selected = destination == selectedScreen,
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
        Canvas(modifier = Modifier) {
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
        selectedScreen = BottomNavItem.Mics,
        onScreenClick = {  }
    )
}