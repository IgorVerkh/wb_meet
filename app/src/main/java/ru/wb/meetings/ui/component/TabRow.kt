package ru.wb.meetings.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.theme.Body1
import ru.wb.meetings.ui.theme.BrandDefault
import ru.wb.meetings.ui.theme.SixSixSix

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