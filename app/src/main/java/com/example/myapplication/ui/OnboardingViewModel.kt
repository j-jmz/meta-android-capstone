package com.example.myapplication.ui

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel

class OnboardingViewModel(private val sharedPrefs: SharedPreferences) : ViewModel() {
    fun saveLoginData(
        firstName: String,
        lastName: String,
        email: String
    ) {
        val editor = sharedPrefs.edit()

        editor.apply() {
            putString("firstName", firstName)
            putString("lastName", lastName)
            putString("email", email)
            apply()
        }
    }

    fun isUserLoggedIn(): Boolean {
        return sharedPrefs.contains("firstName") and
                sharedPrefs.contains("lastName") and
                sharedPrefs.contains("email")
    }

}