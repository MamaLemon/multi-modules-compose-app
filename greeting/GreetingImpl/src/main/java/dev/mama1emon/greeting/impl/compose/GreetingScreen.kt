package dev.mama1emon.greeting.impl.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.mama1emon.feed.navigation.FeedEntry
import dev.mama1emon.navigation.LocalDestinationsProvider
import dev.mama1emon.navigation.find

@Composable
fun GreetingScreen(navController: NavHostController) {
    var inputName by remember { mutableStateOf("") }
    val destinations = LocalDestinationsProvider.current

    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Добро пожаловать",
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        TextField(
            modifier = Modifier.align(Alignment.TopCenter),
            value = inputName,
            onValueChange = { inputName = it }
        )
        Button(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                navController.navigate(
                    destinations.find<FeedEntry>().route(inputName)
                )
            }
        ) {
            Text(text = "Перейти на Ленту")
        }
    }
}