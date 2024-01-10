package com.fconline.user.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
object DateUtil {
    val serverDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
}