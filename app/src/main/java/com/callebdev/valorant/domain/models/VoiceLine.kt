package com.callebdev.valorant.domain.models

data class VoiceLine(
    val maxDuration: Double,
    val mediaList: List<Media>,
    val minDuration: Double,
)
