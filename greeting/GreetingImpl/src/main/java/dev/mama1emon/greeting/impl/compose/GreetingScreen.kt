package dev.mama1emon.greeting.impl.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.mama1emon.feed.navigation.FeedEntry
import dev.mama1emon.greeting.impl.navigation.Greeting
import dev.mama1emon.navigation.Destinations
import dev.mama1emon.navigation.find

@Composable
fun GreetingScreen(navController: NavHostController, destinations: Destinations) {
//    val destinations = LocalDestinationsProvider.current

    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "ДОБРО ПОЖАЛОВАТЬ",
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Button(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                /**
                 * ПРИМЕР НАВИГАЦИИ МЕЖДУ ЭКРАНАМИ РАЗНЫХ МОДУЛЕЙ
                 * С УКАЗАНИЕМ ДОПОЛНИТЕЛЬНЫХ ПАРАМЕТРОВ
                 */
                navController.navigate(
                    destinations.find<FeedEntry>().route
                ) {
                    popUpTo(Greeting.value()) { inclusive = true }
                }
            }
        ) {
            Text(text = "ОТКРЫТЬ ЛЕНТУ")
        }
    }
}