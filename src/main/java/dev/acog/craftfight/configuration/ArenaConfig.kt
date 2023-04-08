package dev.acog.craftfight.configuration

import dev.acog.craftfight.domain.Area
import org.springframework.boot.autoconfigure.security.SecurityProperties
import java.util.*

class ArenaConfig(
    val areas: Map<String, Area> = mutableMapOf(),
    val users: Map<UUID, SecurityProperties.User> = mutableMapOf()
)