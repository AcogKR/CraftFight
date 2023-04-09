package dev.acog.craftfight

import dev.acog.craftfight.command.CommandService
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.context.annotation.Configuration
import java.io.File

@Configuration
open class CraftFightConfig(
    private val plugin: JavaPlugin
) {

    private fun getConfigFile(): File = File(plugin.dataFolder, "config.yml")
    private fun getLangFile(): File = File(plugin.dataFolder, "lang.yml")
    private fun getArenaFile(): File = File(plugin.dataFolder, "arena.yml")
}
