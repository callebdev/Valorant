package com.callebdev.valorant.presentation.uistates

import com.callebdev.valorant.domain.models.Agent

sealed class AgentDetailsScreenState {
    object Loading : AgentDetailsScreenState()
    data class Success(val agent: Agent) : AgentDetailsScreenState()
    data class Error(val errorMessage: String) : AgentDetailsScreenState()
}
