package com.example.myapplication.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.Home
import com.example.myapplication.Onboarding
import com.example.myapplication.Profile
import com.example.myapplication.ui.OnboardingViewModel

@Composable
fun Navigation(navController: NavHostController, onboardingViewModel: OnboardingViewModel) {
    NavHost(
        navController = navController,
        startDestination = if (onboardingViewModel.isUserLoggedIn()){
            Home.route
        }else {
            Onboarding.route
        }
    ){
        composable(Onboarding.route){
            Onboarding(navController, onboardingViewModel)
        }
        composable(Home.route){
            Home(navController)
        }
        composable(Profile.route){
            Profile(navController , onboardingViewModel )
        }
    }
}