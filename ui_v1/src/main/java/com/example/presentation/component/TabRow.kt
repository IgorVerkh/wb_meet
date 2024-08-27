package com.example.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.Body1
import com.example.presentation.theme.BrandDefault
import com.example.presentation.theme.SixSixSix

@Composable
fun MeetingsTabRow(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.Transparent,
    contentColor: Color = BrandDefault,
    indicatorColor: Color = BrandDefault
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = containerColor,
        contentColor = contentColor,
        divider = {},
        indicator = { tabPositions ->
            SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = indicatorColor
            )
        },
        modifier = modifier
    ) {
        tabs.forEachIndexed { index, tabTitle ->
            Tab(
                modifier = Modifier.padding(all = 16.dp),
                selected = selectedTabIndex == index,
                unselectedContentColor = SixSixSix,
                onClick = { onTabClick(index) }
            ) {
                Text(text = tabTitle, style = Body1)
            }
        }
    }
}