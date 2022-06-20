package dev.mama1emon.bottombarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.mama1emon.bottombarapp.ui.theme.BottomBarAppTheme
import dev.mama1emon.greeting.api.navigation.GreetingEntry
import dev.mama1emon.navigation.Destinations
import dev.mama1emon.navigation.LocalDestinationsProvider
import dev.mama1emon.navigation.addToGraph
import dev.mama1emon.navigation.find
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var destinations: Destinations

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomBarAppTheme(darkTheme = false) {
                CompositionLocalProvider(
                    LocalDestinationsProvider provides destinations
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalDestinationsProvider.current

    Box(Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = destinations.find<GreetingEntry>().route()
        ) {
            /**
             * ВСЕ ТОЧКИ ВХОДА, ДОБАВЛЕННЫЕ В DI ГРАФ, БУДУТ АВТОМАТИЧЕСКИ ДОБАВЛЕНЫ
             * В НАВИГАЦИОННЫЙ ГРАФ
             */
            destinations.forEach {
                addToGraph(it.value, navController, destinations)
            }
        }
    }
}