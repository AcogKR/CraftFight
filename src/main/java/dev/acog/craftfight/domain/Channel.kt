package dev.acog.craftfight.domain

import dev.acog.craftfight.domain.type.ArenaType

data class Channel(
    val id: Int,
    val type: ArenaType,

    val red: Set<User>,
    val blue: Set<User>
)