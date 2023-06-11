package com.example.littlelemon.ui.profile

import androidx.lifecycle.ViewModel
import com.example.littlelemon.domain.repository.SharedPrefsRepository
import com.example.littlelemon.ui.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val prefsRepo: SharedPrefsRepository
): ViewModel() {

    private val _state = MutableStateFlow(getUserData())
    val sate: Flow<UserData> = _state

    fun onEvent(event: ProfileEvents){
        when(event) {
            is ProfileEvents.deleteUserData -> deleteUserData()
        }
    }

    private fun deleteUserData() = prefsRepo.deleteData()

    private fun getUserData(): UserData {
        return UserData(
            prefsRepo.getString("firstName", ""),
            prefsRepo.getString("lastName", ""),
            prefsRepo.getString("email", ""),
        )
    }
}