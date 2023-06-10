package com.example.littlelemon.ui.onboarding

import androidx.lifecycle.ViewModel
import com.example.littlelemon.domain.repository.SharedPrefsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val prefsRepo: SharedPrefsRepository
) : ViewModel() {

    data class UserData(
        val firstName: String,
        val lastName: String,
        val email: String,
    )

    fun saveLoginData(
        firstName: String,
        lastName: String,
        email: String
    ) {
        prefsRepo.putString("firstName", firstName)
        prefsRepo.putString("lastName", lastName)
        prefsRepo.putString("email", email)
    }

    fun isUserLoggedIn(): Boolean {
        return prefsRepo.contains("firstName") and
                prefsRepo.contains("lastName") and
                prefsRepo.contains("email")
    }

    fun deleteUserData() = prefsRepo.deleteData()

    fun getUserData(): UserData {
        return UserData(
            prefsRepo.getString("firstName", ""),
            prefsRepo.getString("lastName", ""),
            prefsRepo.getString("email", ""),
        )
    }
}