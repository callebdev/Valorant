package com.callebdev.valorant.data.remote.dto

import com.callebdev.valorant.domain.models.Agent
import com.google.gson.annotations.SerializedName

data class AgentsDto(
    @SerializedName("data") val data: List<AgentResponse>,
    val status: Int,
)

fun AgentsDto.toAgents(): List<Agent> = data.map { it.toAgent() }
