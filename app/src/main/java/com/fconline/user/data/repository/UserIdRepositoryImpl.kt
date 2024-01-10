package com.fconline.user.data.repository

import com.fconline.user.domain.repository.UserIdRepository
import com.fconline.user.network.api.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class UserIdRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserIdRepository {

    override suspend fun getUserId(nickName: String): Flow<String> {
        return flow {
            try {
                apiService.getUserId(nickName)
            } catch (e: IOException) {
                println(e)
            }
        }
    }
}