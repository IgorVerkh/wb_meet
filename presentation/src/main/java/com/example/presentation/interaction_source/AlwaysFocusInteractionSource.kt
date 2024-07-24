package com.example.presentation.interaction_source

import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

internal class AlwaysFocusInteractionSource : MutableInteractionSource {
    override val interactions: MutableSharedFlow<Interaction> = MutableSharedFlow<Interaction>(
    extraBufferCapacity = 16,
    onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    init {
        CoroutineScope(Dispatchers.Main).launch {
            interactions.emit(FocusInteraction.Focus())
        }
    }

    override suspend fun emit(interaction: Interaction) {
        interactions.emit(FocusInteraction.Focus())
    }

    override fun tryEmit(interaction: Interaction): Boolean {
        return interactions.tryEmit(FocusInteraction.Focus())
    }
}