package com.fconline.user.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserIdRepository {
    suspend fun getUserId(nickName: String): Flow<String>
}