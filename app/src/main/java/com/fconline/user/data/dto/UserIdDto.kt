package com.fconline.user.data.dto

import com.google.gson.annotations.SerializedName

data class UserIdDto(
    @SerializedName("ouid") // 계정 식별자
    val id: String
)
