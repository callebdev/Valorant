package com.callebdev.valorant.data.remote.dto

import com.callebdev.valorant.commons.Constants.EMPTY
import com.callebdev.valorant.commons.Constants.ZERO_DOUBLE
import com.callebdev.valorant.domain.models.Ability
import com.callebdev.valorant.domain.models.Agent
import com.callebdev.valorant.domain.models.Media
import com.callebdev.valorant.domain.models.Role
import com.callebdev.valorant.domain.models.VoiceLine

class AgentResponse(
    val abilities: List<AbilityResponse>? = emptyList(),
    val assetPath: String? = EMPTY,
    val background: String? = EMPTY,
    val backgroundGradientColors: List<String>? = emptyList(),
    val bustPortrait: String? = EMPTY,
    val characterTags: List<String>? = emptyList(),
    val description: String? = EMPTY,
    val developerName: String? = EMPTY,
    val displayIcon: String? = EMPTY,
    val displayIconSmall: String? = EMPTY,
    val displayName: String? = EMPTY,
    val fullPortrait: String? = EMPTY,
    val fullPortraitV2: String? = EMPTY,
    val isAvailableForTest: Boolean = false,
    val isBaseContent: Boolean = false,
    val isFullPortraitRightFacing: Boolean = false,
    val isPlayableCharacter: Boolean = false,
    val killfeedPortrait: String? = EMPTY,
    val role: RoleResponse? = null,
    val uuid: String?,
    val voiceLine: VoiceLineResponse? = null,
) {

    data class AbilityResponse(
        val description: String?,
        val displayIcon: String?,
        val displayName: String?,
        val slot: String?,
    )

    data class MediaResponse(
        val id: Int?,
        val wave: String?,
        val wwise: String?,
    )

    data class RoleResponse(
        val assetPath: String?,
        val description: String?,
        val displayIcon: String?,
        val displayName: String?,
        val uuid: String?,
    )

    data class VoiceLineResponse(
        val maxDuration: Double?,
        val mediaList: List<MediaResponse>?,
        val minDuration: Double?,
    )
}

fun AgentResponse.AbilityResponse.toAbility() = Ability(
    description = description ?: EMPTY,
    displayIcon = displayIcon ?: EMPTY,
    displayName = displayName ?: EMPTY,
    slot = slot ?: EMPTY,
)

fun AgentResponse.MediaResponse.toMedia() = Media(
    id = id,
    wave = wave ?: EMPTY,
    wwise = wwise ?: EMPTY,
)

fun AgentResponse.RoleResponse.toRole() = Role(
    assetPath ?: EMPTY,
    description ?: EMPTY,
    displayIcon ?: EMPTY,
    displayName ?: EMPTY,
    uuid ?: EMPTY,
)

fun AgentResponse.VoiceLineResponse.toVoiceLine() = VoiceLine(
    maxDuration ?: ZERO_DOUBLE,
    mediaList?.map { it.toMedia() } ?: emptyList(),
    minDuration ?: ZERO_DOUBLE,
)

fun AgentResponse.toAgent() = Agent(
    abilities = abilities?.let { ability -> ability.map { it.toAbility() } } ?: emptyList(),
    assetPath = assetPath ?: EMPTY,
    background = background ?: EMPTY,
    backgroundGradientColors = backgroundGradientColors ?: emptyList(),
    bustPortrait = bustPortrait ?: EMPTY,
    characterTags = characterTags ?: emptyList(),
    description = description ?: EMPTY,
    developerName = developerName ?: EMPTY,
    displayIcon = displayIcon ?: EMPTY,
    displayIconSmall = displayIconSmall ?: EMPTY,
    displayName = displayName ?: EMPTY,
    fullPortrait = fullPortrait ?: EMPTY,
    fullPortraitV2 = fullPortraitV2 ?: EMPTY,
    isAvailableForTest = isAvailableForTest,
    isBaseContent = isBaseContent,
    isFullPortraitRightFacing = isFullPortraitRightFacing,
    isPlayableCharacter = isPlayableCharacter,
    killfeedPortrait = killfeedPortrait ?: EMPTY,
    role = role?.toRole(),
    uuid = uuid,
    voiceLine = voiceLine?.toVoiceLine(),
)
