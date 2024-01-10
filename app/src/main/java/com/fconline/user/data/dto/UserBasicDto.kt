package com.fconline.user.data.dto

import com.google.gson.annotations.SerializedName

data class UserBasicDto(

    // 계정 식별자
    @SerializedName("ouid")
    val id: String,

    // 유저 닉네임
    @SerializedName("nickname")
    val nickName: String,

    // 유저 레벨
    @SerializedName("level")
    val level: Int
)
