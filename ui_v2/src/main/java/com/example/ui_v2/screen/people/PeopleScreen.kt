package com.example.ui_v2.screen.people

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ui_v2.R
import com.example.ui_v2.component.PersonCard
import com.example.ui_v2.component.WBAppBar

@Composable
internal fun PeopleScreen(navController: NavController) {
    val peopleList = List(10) {
        Person(0, "null", "Pavel", "Backend")
    }

    PeopleContent(
        peopleList = peopleList,
        onPersonClick = { }
    )
}

private data class Person(
    val id: Int,
    val avatar: Any?,
    val name: String,
    val tag: String,
)

@Composable
private fun PeopleContent(
    peopleList: List<Person>,
    onPersonClick: (Int) -> Unit,
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
        WBAppBar(title = stringResource(R.string.event_attendees_appbar))
        Spacer(modifier = Modifier.height(32.dp))
        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Adaptive(104.dp)
        ) {
            items(peopleList) {
                Box(
                    contentAlignment = Alignment.Center,
                ) {
                    PersonCard(
                        avatar = it.avatar,
                        name = it.name,
                        tag = it.tag,
                        onClick = { onPersonClick(it.id) }
                    )
                }
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun PeoplePreview() {
    val peopleList = List(10) {
        Person(0, null, "Pavel", "Backend")
    }

    PeopleContent(
        peopleList = peopleList,
        onPersonClick = { }
    )
}