package com.callebdev.valorant.data.remote.dto

import com.callebdev.valorant.commons.Constants.EMPTY
import com.callebdev.valorant.domain.models.Agent
import com.google.gson.annotations.SerializedName

data class AgentDto(
    @SerializedName("data") val data: AgentResponse,
    val status: Int,
)

fun AgentDto.toAgent(): Agent {
    return Agent(
        abilities = data.abilities?.map { it.toAbility() } ?: emptyList(),
        assetPath = data.assetPath ?: EMPTY,
        background = data.background ?: EMPTY,
        backgroundGradientColors = data.backgroundGradientColors ?: emptyList(),
        bustPortrait = data.bustPortrait ?: EMPTY,
        characterTags = data.characterTags ?: emptyList(),
        description = data.description ?: EMPTY,
        developerName = data.developerName ?: EMPTY,
        displayIcon = data.displayIcon ?: EMPTY,
        displayIconSmall = data.displayIconSmall ?: EMPTY,
        displayName = data.displayName ?: EMPTY,
        fullPortrait = data.fullPortrait ?: EMPTY,
        fullPortraitV2 = data.fullPortraitV2 ?: EMPTY,
        isAvailableForTest = data.isAvailableForTest,
        isBaseContent = data.isBaseContent,
        isFullPortraitRightFacing = data.isFullPortraitRightFacing,
        isPlayableCharacter = data.isPlayableCharacter,
        killfeedPortrait = data.killfeedPortrait ?: EMPTY,
        role = data.role?.toRole(),
        uuid = data.uuid,
        voiceLine = data.voiceLine?.toVoiceLine(),
    )
}
