package com.example.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.theme.Body1

@Composable
fun MiscMenuItem(
    text: String,
    leadingIcon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: Int = R.drawable.ic_back
) {
    MiscMenuItem(
        text = {
            Text(text = text, style = Body1)
        },
        leadingIcon = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = "null"
                )
            }
        },
        onClick = onClick,
        modifier = modifier,
        trailingIcon = trailingIcon
    )
}

@Composable
fun MiscMenuItem(
    text: @Composable () -> Unit,
    leadingIcon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: Int = R.drawable.ic_back
) {
    Row(
        modifier = modifier
            .heightIn(min = 40.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        leadingIcon.invoke()
        Spacer(modifier = Modifier.width(6.dp))
        text.invoke()
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = trailingIcon),
            contentDescription = "null",
            modifier = Modifier.rotate(180f)
        )
    }
}