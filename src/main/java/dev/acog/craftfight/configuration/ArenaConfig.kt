package dev.acog.craftfight.configuration

import dev.acog.craftfight.domain.Area
import lombok.Builder
import org.springframework.boot.autoconfigure.security.SecurityProperties
import java.util.*

@Builder
class ArenaConfig(
    val areas: Map<String, Area> = mutableMapOf(),
    val users: Map<UUID, SecurityProperties.User> = mutableMapOf()
)