package com.example.ui_v2.common

import androidx.annotation.DrawableRes
import com.example.ui_v2.R

enum class CountryPhoneData(
    val phoneCode: String,
    val mask: String,
    @DrawableRes val flag: Int,
    val length: Int,
) {
    RUSSIA("+7", "(000) 000-00-00", R.drawable.ic_russia_flag, 10),
    UNITED_ARAB_EMIRATES("+971", "000 000 0000", R.drawable.ic_united_arab_emirates_flag, 10),
    UNITED_KINGDOM("+44", "000 000 0000", R.drawable.ic_britain_flag, 10),
    GEORGIA("+995", "000 000 000", R.drawable.ic_georgia_flag, 9),
    KYRGYZSTAN("+996", "000 000 000", R.drawable.ic_kyrgyzstan_flag, 9),
    SOUTH_KOREA("+82", "000 000-0000", R.drawable.ic_south_korea_flag, 10),
    KAZAKHSTAN("+7", "000 000 00 00", R.drawable.ic_kazakhstan_flag, 10),
    TURKEY("+90", "000 000 00 00", R.drawable.ic_turkey_flag, 10),
    UNITED_STATES("+1", "(000) 000-0000", R.drawable.ic_usa_flag, 10),
    UZBEKISTAN("+998", "000 000 00 00", R.drawable.ic_uzbekistan_flag, 10)
}