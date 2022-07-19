package com.callebdev.valorant.domain.repositories

import com.callebdev.valorant.data.remote.dto.AgentDto
import com.callebdev.valorant.data.remote.dto.AgentsDto

interface ValorantRepository {
    suspend fun getAgents(): AgentsDto
    suspend fun getAgentById(agentId: String): AgentDto
}
