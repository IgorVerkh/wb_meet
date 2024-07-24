package com.example.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.theme.Body1

@Composable
fun MembersRow(
    members: List<Any?>,
    modifier: Modifier = Modifier,
    limit: Int = 5
) {
    val isLimitReached = members.size > limit

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OverlappingRow(overlappingPercentage = 0.3f) {
            if (isLimitReached) {
                for (i in 0..4) {
                    BorderedSquareAvatar(
                        image = members[i],
                        modifier = Modifier.size(size = 48.dp)
                    )
                }
            } else {
                for (avatar in members) {
                    BorderedSquareAvatar(
                        image = avatar,
                        modifier = Modifier.size(size = 48.dp)
                    )
                }
            }
        }
        if (isLimitReached) {
            Spacer(modifier = Modifier.width(14.dp))
            Text(
                text = "+${members.size-limit}",
                style = Body1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MembersRowPreview() {
    val members = List(15) {
        R.drawable.ic_group_placeholder
    }

    MembersRow(members = members)
}

