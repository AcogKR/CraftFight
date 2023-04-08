package dev.acog.craftfight.domain

import org.bukkit.Location

data class Area(
    val name: String,
    val first: Location,
    val second: Location,
    val spectator: Location,
    val state: Boolean
)
