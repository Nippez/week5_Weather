package com.example.week1kotlinperusteet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.week1kotlinperusteet.ui.HomeScreen
import com.example.week1kotlinperusteet.ui.CalendarScreen
import com.example.week1kotlinperusteet.ui.WeatherScreen
import com.example.week1kotlinperusteet.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            val viewModel: TaskViewModel = viewModel()



            NavHost(
                navController = navController,
                startDestination = ROUTE_HOME
            ) {

                composable(ROUTE_HOME) {
                    HomeScreen(navController, viewModel)
                }

                composable(ROUTE_CALENDAR) {
                    CalendarScreen(navController, viewModel)
                }

                composable(ROUTE_WEATHER) {
                    WeatherScreen(navController)
                }
            }
        }
    }
}