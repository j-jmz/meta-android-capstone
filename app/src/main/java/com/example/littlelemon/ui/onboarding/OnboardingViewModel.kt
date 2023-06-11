package com.example.littlelemon.ui.onboarding

import androidx.lifecycle.ViewModel
import com.example.littlelemon.domain.repository.SharedPrefsRepository
import com.example.littlelemon.ui.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val prefsRepo: SharedPrefsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UserData())
    val state: Flow<UserData> = _state

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            is OnboardingEvent.OnFirstNameChanged -> {
                _state.value = _state.value.copy(firstName = event.firstName)
            }
            is OnboardingEvent.OnLastNameChanged -> {
                _state.value = _state.value.copy(lastName = event.lastName)
            }
            is OnboardingEvent.OnEmailChanged -> {
                _state.value = _state.value.copy(email = event.email)
            }
            is OnboardingEvent.OnSaveUserData -> {
                saveLoginData(_state.value)
            }
        }
    }

    fun isInputDataValid(): Boolean {
       return _state.value.firstName.isNotBlank()
    }

    private fun saveLoginData(
        data: UserData
    ) {
        prefsRepo.putString("firstName", data.firstName)
        prefsRepo.putString("lastName", data.lastName)
        prefsRepo.putString("email", data.email)
    }

    fun isUserLoggedIn(): Boolean {
        return prefsRepo.contains("firstName") and
                prefsRepo.contains("lastName") and
                prefsRepo.contains("email")
    }

}