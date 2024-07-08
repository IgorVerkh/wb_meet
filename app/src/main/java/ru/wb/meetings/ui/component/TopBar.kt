package ru.wb.meetings.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.NeutralActive
import ru.wb.meetings.ui.theme.Subheading1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopBar(
    modifier: Modifier = Modifier,
    contentColor: Color = NeutralActive
) {
    TopAppBar(
        navigationIcon = { Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier.padding(end = 8.dp)) },
        title = { Text(text = "Профиль", style = Subheading1, color = contentColor) },
        actions = { Icon(
            painter = painterResource(id = R.drawable.ic_edit),
            contentDescription = null,
            tint = contentColor) },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMeetingsTopBar(
    modifier: Modifier = Modifier,
    contentColor: Color = NeutralActive
) {
    TopAppBar(
        navigationIcon = { Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier.padding(end = 8.dp)) },
        title = { Text(text = "Мои встречи", style = Subheading1, color = contentColor) },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllMeetingsTopBar(
    modifier: Modifier = Modifier,
    contentColor: Color = NeutralActive
) {
    TopAppBar(
        title = { Text(text = "Встречи", style = Subheading1, color = contentColor) },
        actions = { Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = null,
            tint = contentColor) },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllCommunitiesTopBar(
    modifier: Modifier = Modifier,
    contentColor: Color = NeutralActive
) {
    TopAppBar(
        title = { Text(text = "Сообщества", style = Subheading1, color = contentColor) },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityTopBar(
    label: String,
    modifier: Modifier = Modifier,
    contentColor: Color = NeutralActive
) {
    TopAppBar(
        navigationIcon = { Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier.padding(end = 8.dp)) },
        title = { Text(text = label, style = Subheading1, color = contentColor) },
        modifier = modifier
    )
}

@Preview
@Composable
private fun ProfileTopBarPreview() {
    ProfileTopBar()
}

@Preview
@Composable
private fun MyMeetingsTopBarPreview() {
    MyMeetingsTopBar()
}

@Preview
@Composable
private fun AllMeetingsTopBarPreview() {
    AllMeetingsTopBar()
}

@Preview
@Composable
private fun AllCommunitiesTopBarPreview() {
    AllCommunitiesTopBar()
}

@Preview
@Composable
private fun CommunityTopBarPreview() {
    CommunityTopBar("Designa")
}