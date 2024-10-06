package com.example.ui_v2.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
internal fun MainScreen(
    navController: NavHostController,
) {

}

@Composable
private fun MainScreenContent(
    state: MainScreenState,
    searchBar: @Composable () -> Unit,
    mainSlot: @Composable () -> Unit,
    suggestionsRail: @Composable (() -> Unit)?,
    chipFilter: @Composable (() -> Unit)?,
    trailingContent: @Composable (() -> Unit)?,
) {

}

@Preview
@Composable
private fun MainScreenPreview() {

}