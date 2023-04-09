package dev.acog.craftfight.domain

import org.bukkit.Location

data class Area(
    val name: String,
    var first: Location,
    var second: Location,
    var spectator: Location,
    val state: Boolean
)