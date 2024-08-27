package com.example.presentation.screen.ui_kit.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.typography

@Composable
internal fun Type() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Typography", style = typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Heading 1", style = typography.displayLarge)
        Text(text = "The quick brown fox jumps over the lazy dog", style = typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Heading 2", style = typography.displayMedium)
        Text(text = "The quick brown fox jumps over the lazy dog", style = typography.displayMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Subheading 1", style = typography.titleLarge)
        Text(text = "The quick brown fox jumps over the lazy dog", style = typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Subheading 2", style = typography.titleMedium)
        Text(text = "The quick brown fox jumps over the lazy dog", style = typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Body Text 1", style = typography.bodyLarge)
        Text(text = "The quick brown fox jumps over the lazy dog", style = typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Body Text 2", style = typography.bodyMedium)
        Text(text = "The quick brown fox jumps over the lazy dog", style = typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Metadata 1", style = typography.labelLarge)
        Text(text = "The quick brown fox jumps over the lazy dog", style = typography.labelLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Metadata 2", style = typography.labelMedium)
        Text(text = "The quick brown fox jumps over the lazy dog", style = typography.labelMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Metadata 3", style = typography.labelSmall)
        Text(text = "The quick brown fox jumps over the lazy dog", style = typography.labelSmall)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTypographyScreen() {
    MaterialTheme(typography = typography) {
        Surface {
            Type()
        }
    }
}