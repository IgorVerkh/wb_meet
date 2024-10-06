package com.example.ui_v2.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.then
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.common.CountryPhoneData
import com.example.ui_v2.text_transformation.input.OnlyDigitsTransformation
import com.example.ui_v2.text_transformation.output.PhoneNumberOutputTransformation
import com.example.ui_v2.theme.MeetTheme

@Composable
fun PhoneNumberTextField(
    textFieldState: TextFieldState,
    onCountryClick: (CountryPhoneData) -> Unit,
    modifier: Modifier = Modifier,
    selectedCountry: CountryPhoneData = CountryPhoneData.RUSSIA,
    maskSymbol: Char = '0',
) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        CountryPhoneCode(
            flag = R.drawable.ic_russia_flag,
            phoneCode = "+7",
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = !expanded },
            modifier = Modifier
                .background(MeetTheme.colors.disabled)
        ) {
            CountryPhoneData.entries.forEach { country ->
                DropdownMenuItem(
                    text = {
                        CountryPhoneCode(
                            flag = country.flag,
                            phoneCode = country.phoneCode,
                        )
                    },
                    onClick = {
                        onCountryClick(country)
                        expanded = false
                    },
                    modifier = Modifier
                        .background(MeetTheme.colors.disabled)
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))
        TextField(
            textFieldState = textFieldState,
            placeholder = selectedCountry.mask,
            inputTransformation = OnlyDigitsTransformation.then(
                InputTransformation.maxLength(selectedCountry.length)
            ),
            outputTransformation = PhoneNumberOutputTransformation(
                mask = selectedCountry.mask,
                maskSymbol = maskSymbol
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun CountryPhoneCode(
    @DrawableRes flag: Int,
    phoneCode: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MeetTheme.colors.disabled)
            .padding(horizontal = 16.dp, vertical = 17.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = flag),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = phoneCode,
            style = MeetTheme.typo.titleSmall,
            color = Color.Black
        )
    }
}


@Preview(showSystemUi = true)
@Composable
private fun PhoneNumberTextFieldPreview() {
    val textFieldState = rememberTextFieldState("9995856190")

    PhoneNumberTextField(
        textFieldState = textFieldState,
        onCountryClick = {},
        modifier = Modifier.fillMaxWidth(),
    )
}