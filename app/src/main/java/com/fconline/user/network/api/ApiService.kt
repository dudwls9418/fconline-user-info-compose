package com.fconline.user.network.api

import com.fconline.user.data.dto.MatchDto
import com.fconline.user.data.dto.MaxDivisionDto
import com.fconline.user.data.dto.TradeDto
import com.fconline.user.data.dto.UserBasicDto
import com.fconline.user.data.dto.UserIdDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // 계정 식별자(ouid) 조회
    @GET("/fconline/v1/id")
    suspend fun getUserId(
        @Query("nickname") nickname: String
    ): Call<UserIdDto>

    // 기본 정보 조회
    @GET("/fconline/v1/user/basic")
    suspend fun getUserBasic(
        @Query("ouid") ouid: String
    ): Call<UserBasicDto>

    // 역대 최고 등급 조회
    @GET("/fconline/v1/user/maxdivision")
    suspend fun getUserMaxDivision(
        @Query("ouid") ouid: String
    ): Call<MaxDivisionDto>

    // 유저의 매치 기록 조회
    @GET("/fconline/v1/user/match")
    suspend fun getUserMatch(
        @Query("ouid") ouid: String,
        @Query("matchtype") matchType: String
    ): Call<MatchDto>

    // 유저의 거래 기록 조회
    @GET("/fconline/v1/user/trade")
    suspend fun getUserTrade(
        @Query("tradetype") tradeType: String
    ): Call<TradeDto>
}