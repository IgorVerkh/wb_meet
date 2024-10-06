package com.example.ui_v2.text_transformation.input

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly

internal object OnlyDigitsTransformation : InputTransformation {

    override val keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)

    override fun TextFieldBuffer.transformInput() {
        if (!this.asCharSequence().isDigitsOnly()) {
            this.revertAllChanges()
        }
    }
}