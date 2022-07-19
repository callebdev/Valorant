package com.callebdev.valorant.presentation.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.callebdev.valorant.presentation.components.AgentDetails
import com.callebdev.valorant.presentation.uistates.AgentDetailsScreenState
import com.callebdev.valorant.presentation.viewmodels.AgentDetailsViewModel

@Composable
fun AgentDetailsScreen(navController: NavController, agentDetailsViewModel: AgentDetailsViewModel = hiltViewModel()) {

    when (val state = agentDetailsViewModel.agentsScreenState.value) {
        is AgentDetailsScreenState.Error -> ErrorScreen(errorMessage = state.errorMessage, onCloseError = { navController.popBackStack() })
        AgentDetailsScreenState.Loading -> LoadingScreen()
        is AgentDetailsScreenState.Success -> AgentDetails(state.agent) {
            navController.popBackStack()
        }
    }
}
