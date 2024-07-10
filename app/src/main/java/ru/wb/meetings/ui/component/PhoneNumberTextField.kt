package ru.wb.meetings.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.Body1
import ru.wb.meetings.ui.theme.NeutralDisabled
import ru.wb.meetings.ui.theme.NeutralOffWhite

enum class CountryCodes(val phoneCode: String, val mask: String, val flag: Int) {
    RUSSIA("+7","0000 00-00", R.drawable.ic_russia_flag),
    UNITED_ARAB_EMIRATES("+971", "000 000 0000", R.drawable.ic_united_arab_emirates_flag),
    UNITED_KINGDOM("+44", "000 000 0000", R.drawable.ic_britain_flag),
    GEORGIA("+995", "000 000 000", R.drawable.ic_georgia_flag),
    KYRGYZSTAN("+996", "000 000 000", R.drawable.ic_kyrgyzstan_flag),
    SOUTH_KOREA("+82", "000 000-0000", R.drawable.ic_south_korea_flag),
    KAZAKHSTAN("+7","000 000 00 00", R.drawable.ic_kazakhstan_flag),
    TURKEY("+90", "000 000 00 00", R.drawable.ic_turkey_flag),
    UNITED_STATES("+1", "(000) 000-0000", R.drawable.ic_usa_flag),
    UZBEKISTAN("+998", "000 000 00 00", R.drawable.ic_uzbekistan_flag);
}


@Composable
fun PhoneNumberTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    maskSymbol: Char = '0'
) {
    var selectedCountry by remember { mutableStateOf(CountryCodes.RUSSIA) }
    var expanded by remember { mutableStateOf(false) }
    
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        CountryPhoneCode(
            flag = selectedCountry.flag,
            phoneCode = selectedCountry.phoneCode,
            textColor = if (value.isEmpty()) NeutralDisabled else Color.Black,
            modifier = Modifier.clickable {
                expanded = !expanded
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = !expanded },
            modifier = Modifier
                .background(NeutralOffWhite)
        ) {
            CountryCodes.entries.forEach { country ->
                DropdownMenuItem(
                    text = {
                        CountryPhoneCode(
                            flag = country.flag,
                            phoneCode = country.phoneCode,
                            textColor = if (value.isEmpty()) NeutralDisabled else Color.Black
                        )
                    },
                    onClick = {
                        selectedCountry = country
                        expanded = false
                    },
                    modifier = Modifier
                        .background(NeutralOffWhite)
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        BasicTextField(
            modifier = modifier
                .clip(RoundedCornerShape(5.dp))
                .background(NeutralOffWhite)
                .fillMaxWidth(),
            value = value.take(selectedCountry.mask.count { it == maskSymbol }),
            onValueChange = { phoneNumber ->
                onValueChange(phoneNumber.take(selectedCountry.mask.count { it == maskSymbol }))
            },
            textStyle = Body1,
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(NeutralOffWhite)
                ) {
                    if (value.isEmpty())
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = selectedCountry.mask,
                            style = Body1,
                            color = NeutralDisabled
                        )
                    innerTextField()
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            visualTransformation = PhoneVisualTransformation(selectedCountry.mask, maskSymbol),
        )
    }
}

class PhoneVisualTransformation(val mask: String, val maskNumber: Char) : VisualTransformation {

    private val maxLength = mask.count { it == maskNumber }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != maskNumber) {
                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(trimmed[textIndex++])
                maskIndex++
            }
        }

        return TransformedText(annotatedString, PhoneOffsetMapper(mask, maskNumber))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PhoneVisualTransformation) return false
        if (mask != other.mask) return false
        if (maskNumber != other.maskNumber) return false
        return true
    }

    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

private class PhoneOffsetMapper(val mask: String, val numberChar: Char) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != numberChar) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != numberChar }
}

@Composable
private fun CountryPhoneCode(
    flag: Int,
    phoneCode: String,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(NeutralOffWhite)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.padding(horizontal = 8.dp),
            painter = painterResource(id = flag),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(end = 8.dp),
            text = phoneCode,
            style = Body1,
            color = textColor
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PhoneNumberTextFieldPreview() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PhoneNumberTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.align(Alignment.Center)
        )
    }
}