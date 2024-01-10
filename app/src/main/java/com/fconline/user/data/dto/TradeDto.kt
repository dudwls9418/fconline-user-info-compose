package com.fconline.user.data.dto

import com.google.gson.annotations.SerializedName

data class TradeDto(
    val tradeList: List<TradeList>
)

data class TradeList(

    // 거래 일자 (구매일 경우, 구매 등록 시점 / 판매일 경우, 판매 완료 시점)
    @SerializedName("tradeDate")
    val tradeDate: String,

    // 거래 고유 식별자
    @SerializedName("saleSn")
    val saleSn: String,

    // 선수 고유 식별자
    @SerializedName("spid")
    val spid: Int,

    // 거래 선수 강화 등급
    @SerializedName("grade")
    val grade: Int,

    // 거래 선수 가치
    @SerializedName("value")
    val value: Int
)