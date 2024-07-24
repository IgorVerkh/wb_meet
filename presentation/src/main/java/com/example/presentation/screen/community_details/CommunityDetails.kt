package com.example.presentation.screen.community_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.presentation.R
import com.example.presentation.component.CommunityTopBar
import com.example.presentation.component.MeetingsBottomNavBar
import com.example.presentation.component.MeetingsList
import com.example.presentation.theme.Body1
import com.example.presentation.theme.Metadata1
import com.example.presentation.theme.NeutralWeak
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun CommunityDetails(
    id: Int,
    navController: NavHostController,
    viewModel: CommunityDetailsViewModel = koinViewModel()
) {
    // TODO: fix so it wouldn't trigger on recompositions or add id to vm constructor
    viewModel.getCommunityDetails(id)
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    // TODO: separate screen into states
    when(uiState) {
        CommunityDetailsState.Error -> null
        CommunityDetailsState.Loading -> null
        is CommunityDetailsState.Success ->
            Scaffold(
                topBar = { CommunityTopBar(
                    label = "Designa",
                    modifier = Modifier.padding(start = 8.dp, end = 24.dp)
                ) },
                bottomBar = { MeetingsBottomNavBar(navController = navController) }
            ) { innerPadding ->
                CommunityDetailsContent(
                    community = (uiState as CommunityDetailsState.Success).community,
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


}

@Composable
private fun CommunityDetailsContent(
    community: Community,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = community.description,
            style = Metadata1,
            color = NeutralWeak
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            // TODO: string res
            text = stringResource(R.string.communities_meetings),
            style = Body1,
            color = NeutralWeak
        )
        Spacer(modifier = Modifier.height(16.dp))
        MeetingsList(meetingsList = community.meetings)
    }
}