package com.example.myapplication.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.Profile
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Home(navController: NavHostController) {
    Column() {
        Row {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(bottom = 20.dp, top = 20.dp)
                    .weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "",

                modifier = Modifier
                    .height(90.dp)
                    .clickable { navController.navigate(Profile.route)  }
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    MyApplicationTheme {
    }
}