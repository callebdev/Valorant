package com.callebdev.valorant.data.remote

import com.callebdev.valorant.data.remote.dto.AgentDto
import com.callebdev.valorant.data.remote.dto.AgentsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantApi {

    @GET("/v1/agents")
    suspend fun getAgents(): AgentsDto

    @GET("/v1/agents/{agentId}")
    suspend fun getAgentById(@Path("agentId") agentId: String): AgentDto
}
