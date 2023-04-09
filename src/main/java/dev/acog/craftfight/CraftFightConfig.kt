package dev.acog.craftfight

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.context.annotation.Configuration
import java.io.File

@Configuration
open class CraftFightConfig(
    private val plugin: JavaPlugin
) {


    @PostConstruct
    fun start() {

    }

    @PreDestroy
    fun stop() {

    }

    private fun getConfigFile(): File = File(plugin.dataFolder, "config.yml")
    private fun getLangFile(): File = File(plugin.dataFolder, "lang.yml")
    private fun getArenaFile(): File = File(plugin.dataFolder, "arena.yml")
}

/*

Config 만들어야 함

 */