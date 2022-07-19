package com.callebdev.valorant.presentation.uistates

import com.callebdev.valorant.domain.models.Agent

sealed class AgentsScreenState {
    object Loading : AgentsScreenState()
    data class Success(val agents: List<Agent>) : AgentsScreenState()
    data class Error(val errorMessage: String) : AgentsScreenState()
}
