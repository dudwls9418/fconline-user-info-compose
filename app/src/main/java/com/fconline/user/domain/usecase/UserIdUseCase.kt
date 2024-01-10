package com.fconline.user.domain.usecase

import com.fconline.user.domain.repository.UserIdRepository
import javax.inject.Inject

class UserIdUseCase @Inject constructor(
    private val userIdRepository: UserIdRepository
) {
    suspend fun getUserId(nickName: String) = userIdRepository.getUserId(nickName)
}