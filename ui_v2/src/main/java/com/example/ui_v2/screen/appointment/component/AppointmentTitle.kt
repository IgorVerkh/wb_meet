package com.example.ui_v2.screen.appointment.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.ui_v2.R
import com.example.ui_v2.theme.MeetTheme

@Composable
internal fun AppointmentTitle(
    title: String,
    onDismissClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MeetTheme.typo.displayLarge
        )
        Image(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clickable { onDismissClick() }
        )
    }
}