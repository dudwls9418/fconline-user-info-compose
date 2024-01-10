package com.fconline.user.data.dto

import com.google.gson.annotations.SerializedName

data class MaxDivisionDto(

    // 매치 종류
    @SerializedName("matchType")
    val matchType: Int,

    // 등급 식별자
    @SerializedName("division")
    val division: Int,

    // 최고 등급 달성 일자
    @SerializedName("achievementDate")
    val achievementDate: String
)
