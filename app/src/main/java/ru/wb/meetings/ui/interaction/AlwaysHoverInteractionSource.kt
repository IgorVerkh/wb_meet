package ru.wb.meetings.ui.interaction

import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class AlwaysHoverInteractionSource : MutableInteractionSource {
    override val interactions: MutableSharedFlow<Interaction> = MutableSharedFlow<Interaction>(
        extraBufferCapacity = 16,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    init {
        CoroutineScope(Dispatchers.Main).launch {
            interactions.emit(HoverInteraction.Enter())
        }
    }

    override suspend fun emit(interaction: Interaction) {
        interactions.emit(HoverInteraction.Enter())
    }

    override fun tryEmit(interaction: Interaction): Boolean {
        return interactions.tryEmit(HoverInteraction.Enter())
    }
}