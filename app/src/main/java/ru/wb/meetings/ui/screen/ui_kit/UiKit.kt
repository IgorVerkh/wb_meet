package ru.wb.meetings.ui.screen.ui_kit

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.R
import ru.wb.meetings.ui.component.CommunityCard
import ru.wb.meetings.ui.component.MeetButton
import ru.wb.meetings.ui.component.MeetingCard
import ru.wb.meetings.ui.component.MeetingsBottomNavBar
import ru.wb.meetings.ui.component.MeetingsOutlinedButton
import ru.wb.meetings.ui.component.MeetingsTextButton
import ru.wb.meetings.ui.component.MembersRow
import ru.wb.meetings.ui.component.OneTimePassword
import ru.wb.meetings.ui.component.PhoneNumberTextField
import ru.wb.meetings.ui.component.RoundAvatar
import ru.wb.meetings.ui.component.RoundAvatarEdit
import ru.wb.meetings.ui.component.SearchBar
import ru.wb.meetings.ui.component.SquareAvatar
import ru.wb.meetings.ui.component.TagChip
import ru.wb.meetings.ui.interaction.AlwaysHoverInteractionSource
import ru.wb.meetings.ui.model.Community
import ru.wb.meetings.ui.model.Meeting
import ru.wb.meetings.ui.screen.ui_kit.component.Type

@Composable
fun UiKit(navController: NavHostController) {
    var searchText by remember { mutableStateOf("") }

    UiKitContent(
        searchText = searchText,
        onSearchTextChange = { searchText = it }
    )
}

@Composable
private fun UiKitContent(
    searchText: String,
    onSearchTextChange: (String) -> Unit
) {
    // TODO: Refactor. Hoist
    var password by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Button", fontSize = 24.sp, modifier = Modifier.padding(bottom = 8.dp))
        DefaultButtonsRow()
        HoveredButtonsRow()
        DisabledButtonsRow()
        Type()
        RoundAvatar(image = R.drawable.ic_avatar_placeholder, modifier = Modifier.size(size = 200.dp))
        Spacer(modifier = Modifier.height(16.dp))
        RoundAvatarEdit(
            image = R.drawable.ic_avatar_placeholder,
            modifier = Modifier.size(size = 200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        SquareAvatar(image = R.drawable.ic_group_placeholder, modifier = Modifier.size(size = 48.dp))
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(
            text = searchText,
            onValueChange = onSearchTextChange)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            TagChip(text = "Python")
            Spacer(modifier = Modifier.width(4.dp))
            TagChip(text = "Junior")
            Spacer(modifier = Modifier.width(4.dp))
            TagChip(text = "Moscow")
        }
        Spacer(modifier = Modifier.height(16.dp))
        MeetingCard(
            meeting = Meeting(
                title = "Developer meeting",
                date = "13.09.2024",
                city = "Казань",
                image = R.drawable.ic_group_placeholder,
                tags = listOf("Python", "Junior")),
            isOver = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        CommunityCard(
            Community(title = "Designa", image = R.drawable.ic_group_placeholder, peopleCount = 10000)
        )
        Spacer(modifier = Modifier.height(16.dp))
        MembersRow(members = listOf(
            R.drawable.ic_group_placeholder,
            R.drawable.ic_group_placeholder,
            R.drawable.ic_group_placeholder,))
        Spacer(modifier = Modifier.height(16.dp))
        MeetingsBottomNavBar(
            navController = rememberNavController(),
            elevation = 0.dp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OneTimePassword(
                value = password,
                onValueChange = {
                    password = it
                },
                actionDone = {},
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        PhoneNumberTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it }
        )
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
private fun DefaultButtonsRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState())
    ) {
        MeetButton(onClick = { /*TODO*/ }) {
            Text(text = "Button", fontSize = 16.sp)
        }
        MeetingsOutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Button", fontSize = 16.sp)
        }
        MeetingsTextButton(onClick = { /*TODO*/ }) {
            Text(text = "Button", fontSize = 16.sp)
        }
    }
}

@Composable
private fun HoveredButtonsRow(
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { AlwaysHoverInteractionSource() }
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState())
    ) {
        MeetButton(onClick = { /*TODO*/ }, interactionSource = interactionSource) {
            Text(text = "Button", fontSize = 16.sp)
        }
        MeetingsOutlinedButton(onClick = { /*TODO*/ }, interactionSource = interactionSource) {
            Text(text = "Button", fontSize = 16.sp)
        }
        MeetingsTextButton(onClick = { /*TODO*/ }, interactionSource = interactionSource) {
            Text(text = "Button", fontSize = 16.sp)
        }
    }
}

@Composable
private fun DisabledButtonsRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState())
    ) {
        MeetButton(onClick = { /*TODO*/ }, enabled = false) {
            Text(text = "Button", fontSize = 16.sp)
        }
        MeetingsOutlinedButton(onClick = { /*TODO*/ }, enabled = false) {
            Text(text = "Button", fontSize = 16.sp)
        }
        MeetingsTextButton(onClick = { /*TODO*/ }, enabled = false) {
            Text(text = "Button", fontSize = 16.sp)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun UiKitPreview() {
    UiKitContent(
        searchText = "",
        onSearchTextChange = {}
    )
}