package com.callebdev.valorant.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.callebdev.valorant.commons.Constants.PARAM_AGENT_UUID
import com.callebdev.valorant.presentation.screens.AgentDetailsScreen
import com.callebdev.valorant.presentation.screens.AgentsScreen

@Preview
@Composable
fun NavigationGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.AgentsScreen.route,
    ) {

        composable(route = Screen.AgentsScreen.route) {
            AgentsScreen(navController)
        }

        composable(route = Screen.AgentDetails.route + "/{$PARAM_AGENT_UUID}") {
            AgentDetailsScreen(navController)
        }
    }
}
