package com.example.ui_v2.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v2.theme.BrandDefault
import com.example.ui_v2.theme.Disabled
import com.example.ui_v2.theme.DisabledContent
import com.example.ui_v2.theme.Subheading1
import com.example.ui_v2.theme.gradientViolet
import com.example.ui_v2.theme.gradientSmoky

internal enum class LoadingButtonState {
    ACTIVE, LOADING, DISABLED
}

internal data class LoadingButtonColors(
    val contentColor: Color = Color.White,
    val containerGradient: Brush = gradientViolet,
    val disabledContentColor: Color = DisabledContent,
    val disabledContainerGradient: Brush = SolidColor(DisabledContent)
)

@Composable
internal fun LoadingButtonPrimary(
    text: String,
    onClick: () -> Unit,
    loadingButtonState: LoadingButtonState,
    modifier: Modifier = Modifier,
) {
    LoadingButton(
        text = text,
        onClick = onClick,
        loadingButtonState = loadingButtonState,
        modifier = modifier,
        colors = LoadingButtonColors(
            contentColor = Color.White,
            containerGradient = gradientViolet,
            disabledContentColor = DisabledContent,
            disabledContainerGradient = SolidColor(Disabled)
        )
    )
}

@Composable
internal fun LoadingButtonSecondary(
    text: String,
    onClick: () -> Unit,
    loadingButtonState: LoadingButtonState,
    modifier: Modifier = Modifier,
) {
    LoadingButton(
        text = text,
        onClick = onClick,
        loadingButtonState = loadingButtonState,
        modifier = modifier,
        colors = LoadingButtonColors(
            contentColor = BrandDefault,
            containerGradient = gradientSmoky,
            disabledContentColor = DisabledContent,
            disabledContainerGradient = SolidColor(Disabled)
        )
    )
}

@Composable
internal fun LoadingButton(
    text: String,
    onClick: () -> Unit,
    loadingButtonState: LoadingButtonState,
    modifier: Modifier = Modifier,
    colors: LoadingButtonColors = LoadingButtonColors(),
) {
    val content: @Composable () -> Unit = when (loadingButtonState) {
        LoadingButtonState.ACTIVE -> {
            {
                Text(
                    text = text,
                    color = colors.contentColor,
                    style = Subheading1
                )
            }
        }

        LoadingButtonState.LOADING -> {
            {
                CircularProgressIndicator(
                    color = colors.contentColor,
                    strokeWidth = 2.dp,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        LoadingButtonState.DISABLED -> {
            {
                Text(
                    text = text,
                    color = colors.disabledContentColor,
                    style = Subheading1,
                )
            }
        }
    }
    val containerGradient = when (loadingButtonState) {
        LoadingButtonState.ACTIVE, LoadingButtonState.LOADING -> colors.containerGradient
        LoadingButtonState.DISABLED -> colors.disabledContainerGradient
    }
    Surface(
        modifier = modifier
            .clickable(enabled = loadingButtonState == LoadingButtonState.ACTIVE) { onClick() }
            .defaultMinSize(
                minWidth = ButtonDefaults.MinWidth,
                minHeight = 56.dp
            )
            .clip(RoundedCornerShape(size = 16.dp))
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(containerGradient)
                .padding(8.dp)
        ) {
            content.invoke()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LoadingButtonPreview() {
    var state by remember { mutableStateOf(LoadingButtonState.ACTIVE) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            LoadingButtonPrimary(
                text = "Оплатить",
                loadingButtonState = state,
                onClick = { state = LoadingButtonState.LOADING },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            LoadingButtonSecondary(
                text = "Оплатить",
                loadingButtonState = state,
                onClick = { state = LoadingButtonState.LOADING },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { state = LoadingButtonState.ACTIVE }
                ) {
                    Text(text = "Active")
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { state = LoadingButtonState.DISABLED }
                ) {
                    Text(text = "Disabled")
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }

    }
}