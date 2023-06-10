package com.example.littlelemon.ui.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.Onboarding
import com.example.littlelemon.R
import com.example.littlelemon.ui.onboarding.OnboardingViewModel
import com.example.littlelemon.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavHostController, onboardingViewModel: OnboardingViewModel) {

    Column() {
        Column(modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(bottom = 20.dp, top = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Profile Information",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 10.dp, top = 60.dp, bottom = 60.dp)
            )
            OutlinedTextField(
                value = onboardingViewModel.getUserData().firstName,
                onValueChange = {},
                label = { Text(text = "First Name") },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 40.dp, bottom = 15.dp)
            )
            OutlinedTextField(
                value = onboardingViewModel.getUserData().lastName,
                onValueChange = {},
                label = { Text(text = "Last Name") },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 15.dp)
            )
            OutlinedTextField(
                value = onboardingViewModel.getUserData().email,
                onValueChange = {},
                label = { Text(text = "Email") },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 15.dp)
            )
        }
        Button(
            onClick = {
                onboardingViewModel.deleteUserData()
                navController.navigate(Onboarding.route)
            },
            border = BorderStroke(0.5.dp, Color.Red),
            shape = RoundedCornerShape(25),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                "Log out",
                color = Color.Black
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    MyApplicationTheme {
    }
}