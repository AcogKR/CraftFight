package dev.acog.craftfight.service

import dev.acog.craftfight.CraftFightConfig
import dev.acog.craftfight.configuration.ArenaConfig
import dev.acog.craftfight.domain.User
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.stereotype.Service
import java.io.File
import java.util.UUID

@Service
class UserService(
    private val plugin: JavaPlugin,
    private val arena: ArenaConfig
) {

}