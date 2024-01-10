package com.fconline.user.data.dto

import com.google.gson.annotations.SerializedName

data class MatchDto(

    // 매치 고유 식별자
    @SerializedName("matchId")
    val matchId: String
)
