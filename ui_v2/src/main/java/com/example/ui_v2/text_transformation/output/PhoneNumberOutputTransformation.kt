package com.example.ui_v2.text_transformation.output

import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.insert

internal class PhoneNumberOutputTransformation(
    val mask: String,
    val maskSymbol: Char,
) : OutputTransformation {

    override fun TextFieldBuffer.transformOutput() {
        mask.forEachIndexed { index, char ->
            if (char != maskSymbol && index < length) {
                insert(index, char.toString())
            }
        }
    }
}