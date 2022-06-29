package com.mikeschvedov.gamingtrackerms.model

data class Game(
    val gameName: String,
    val totalHours: String,
    val gameImage: Int,
    val gamePercent: Int?,
    val gameAchievements: String,
    val hasStory: Boolean,
    val hasPlatinum: Boolean,
    val difficultyMod1: String,
    val difficultyMod2: String,
    val difficultyMod3: String,
    val difficultyMod4: String,
    val playInfo1: String,
    val playInfo2: String,
    val playInfo3: String,
    val isTop10: Boolean

)
