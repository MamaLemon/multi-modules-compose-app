package dev.mama1emon.feed.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navController: NavHostController, newsId: String) {
//    Scaffold(
//        bottomBar = { BottomNavigationBar(navController) }
//    ) {
    Box(
        modifier = Modifier
//            .padding(it)
            .background(Color.Blue)
            .fillMaxSize()
    ) {
        Text(text = "Detail #$newsId", modifier = Modifier.align(Alignment.Center))
    }
//    }
}