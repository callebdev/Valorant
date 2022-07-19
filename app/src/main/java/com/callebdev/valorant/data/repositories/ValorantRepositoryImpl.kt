package com.callebdev.valorant.data.repositories

import com.callebdev.valorant.data.remote.ValorantApi
import com.callebdev.valorant.data.remote.dto.AgentDto
import com.callebdev.valorant.data.remote.dto.AgentsDto
import com.callebdev.valorant.domain.repositories.ValorantRepository
import javax.inject.Inject

class ValorantRepositoryImpl @Inject constructor(private val valorantApi: ValorantApi) : ValorantRepository {
    override suspend fun getAgents(): AgentsDto = valorantApi.getAgents()

    override suspend fun getAgentById(agentId: String): AgentDto = valorantApi.getAgentById(agentId)
}
