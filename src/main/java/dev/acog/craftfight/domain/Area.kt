package dev.acog.craftfight.domain

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import dev.acog.craftfight.configuration.converter.LocationSerializer
import org.bukkit.Location

@JsonSerialize(using = LocationSerializer::class)
data class Area(
    val name: String,
    var first: Location,
    var second: Location,
    var spectator: Location,
    val state: Boolean
)