package com.callebdev.valorant.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.callebdev.valorant.presentation.components.AgentsPagerSlider
import com.callebdev.valorant.presentation.navigation.Screen
import com.callebdev.valorant.presentation.uistates.AgentsScreenState
import com.callebdev.valorant.presentation.viewmodels.AgentsViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AgentsScreen(navController: NavController, viewModel: AgentsViewModel = hiltViewModel()) {

    val state = viewModel.agentsScreenState.value

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp), horizontalArrangement = Arrangement.Center) {
            Text(text = "Valorant Agents", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }

        when (state) {
            is AgentsScreenState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize(), errorMessage = state.errorMessage)
            AgentsScreenState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
            is AgentsScreenState.Success -> {
                if (state.agents.isNotEmpty()) {
                    AgentsPagerSlider(agents = state.agents) {
                        navController.navigate(Screen.AgentDetails.route + "/${it.uuid}")
                    }
                } else {
                    Box(modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp), contentAlignment = Alignment.Center) {
                        Text("All agents are dead!", style = MaterialTheme.typography.headlineLarge)
                    }
                }
            }
        }
    }
}
