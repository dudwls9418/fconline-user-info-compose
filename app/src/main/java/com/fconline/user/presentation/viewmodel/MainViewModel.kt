package com.fconline.user.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fconline.user.domain.usecase.UserIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userIdUseCase: UserIdUseCase
) : ViewModel() {

    fun getUserId(nickName: String) {
        viewModelScope.launch {
            userIdUseCase.getUserId(nickName)
            Log.e("MainViewModel" , "nickName : $nickName")
        }
    }

}