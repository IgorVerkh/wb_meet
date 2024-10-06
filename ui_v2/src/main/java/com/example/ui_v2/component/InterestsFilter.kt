package com.example.ui_v2.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v2.model.InterestTag

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun InterestsFilter(
    interestsMap: Map<InterestTag, Boolean>,
    onInterestClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        interestsMap.forEach { (tag, isActive) ->
            MediumTag(
                text = tag.label,
                onClick = { onInterestClick(tag.label) },
                state = if (isActive) TagState.ACTIVE else TagState.SECONDARY,
                enabled = true
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun InterestsFilterPreview() {
    val interestsMap = mapOf(
        InterestTag(1, "Design") to false,
        InterestTag(1, "Development") to true,
        InterestTag(1, "Product management") to false,
        InterestTag(1, "Project management") to false,
        InterestTag(1, "Backend") to true,
        InterestTag(1, "Frontend") to false,
        InterestTag(1, "Mobile") to false,
        InterestTag(1, "Тестирование") to false,
        InterestTag(1, "Продажи") to false,
        InterestTag(1, "Бизнес") to false,
        InterestTag(1, "Безопасность") to false,
        InterestTag(1, "Web") to true,
        InterestTag(1, "Девопс") to false,
        InterestTag(1, "Маркетинг") to false,
        InterestTag(1, "Аналитика") to false,
        InterestTag(0, "Все категории") to false,
    )
    Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 40.dp)) {
        InterestsFilter(interestsMap = interestsMap, onInterestClick = {})
    }

}