package com.example.profile.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Profile", modifier = Modifier.align(Alignment.Center))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            onClick = { navController.navigate("subscription") }
        ) {
            Box {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "Subscription"
                )
            }
        }
    }
}