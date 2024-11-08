package com.example.presentation.screen.communities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.domain.model.Community
import com.example.domain.model.User
import com.example.presentation.R
import com.example.presentation.component.AllCommunitiesTopBar
import com.example.presentation.component.CommunityCardList
import com.example.presentation.component.MeetingsBottomNavBar
import com.example.presentation.component.SearchBar
import com.example.presentation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun Communities(
    navController: NavHostController,
    viewModel: CommunitiesViewModel = koinViewModel()
) {
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    Scaffold(
        topBar = { AllCommunitiesTopBar(modifier = Modifier.padding(start = 8.dp, end = 24.dp)) },
        bottomBar = { MeetingsBottomNavBar(navController = navController) }
    ) { innerPadding ->
        CommunitiesContent(
            communities = uiState.communitiesList,
            onCommunityClick = { id ->
                navController.navigate("${Screen.CommunityDetails.route}/$id")
            },
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
private fun CommunitiesContent(
    communities: List<Community>,
    onCommunityClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SearchBar(value = "", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
        CommunityCardList(
            communities = communities,
            onCommunityClick = onCommunityClick
        )
    }
}