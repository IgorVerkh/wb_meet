package com.example.presentation.screen.phone_number

import androidx.annotation.StringRes
import com.example.presentation.R

enum class CountryPhoneData(
    val phoneCode: String,
    val mask: String,
    @StringRes val flag: Int,
) {
    RUSSIA("+7", "0000 00-00", R.drawable.ic_russia_flag),
    UNITED_ARAB_EMIRATES("+971", "000 000 0000", R.drawable.ic_united_arab_emirates_flag),
    UNITED_KINGDOM("+44", "000 000 0000", R.drawable.ic_britain_flag),
    GEORGIA("+995", "000 000 000", R.drawable.ic_georgia_flag),
    KYRGYZSTAN("+996", "000 000 000", R.drawable.ic_kyrgyzstan_flag),
    SOUTH_KOREA("+82", "000 000-0000", R.drawable.ic_south_korea_flag),
    KAZAKHSTAN("+7", "000 000 00 00", R.drawable.ic_kazakhstan_flag),
    TURKEY("+90", "000 000 00 00", R.drawable.ic_turkey_flag),
    UNITED_STATES("+1", "(000) 000-0000", R.drawable.ic_usa_flag),
    UZBEKISTAN("+998", "000 000 00 00", R.drawable.ic_uzbekistan_flag)
}