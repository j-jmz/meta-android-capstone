package com.example.littlelemon.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.Home
import com.example.littlelemon.Onboarding
import com.example.littlelemon.Profile
import com.example.littlelemon.ui.home.Home
import com.example.littlelemon.ui.onboarding.Onboarding
import com.example.littlelemon.ui.onboarding.OnboardingViewModel
import com.example.littlelemon.ui.profile.Profile
import com.example.littlelemon.ui.profile.ProfileViewModel

@Composable
fun Navigation(
    onboardingViewModel: OnboardingViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if (onboardingViewModel.isUserLoggedIn()) {
            Home.route
        } else {
            Onboarding.route
        }
    ) {
        composable(Onboarding.route) {
            Onboarding(navController, onboardingViewModel)
        }
        composable(Home.route) {
            Home(navController)
        }
        composable(Profile.route) {
            Profile(navController, profileViewModel)
        }
    }
}