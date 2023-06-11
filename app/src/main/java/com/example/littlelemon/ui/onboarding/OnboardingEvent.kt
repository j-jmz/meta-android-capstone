package com.example.littlelemon.ui.onboarding

sealed class OnboardingEvent{
    data class OnFirstNameChanged(val firstName: String): OnboardingEvent()
    data class OnLastNameChanged(val lastName: String): OnboardingEvent()
    data class OnEmailChanged(val email: String): OnboardingEvent()
    object OnSaveUserData: OnboardingEvent()
}
