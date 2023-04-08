package dev.acog.craftfight

import dev.acog.craftfight.configuration.LangConfig
import dev.acog.craftfight.configuration.PluginConfig
import io.typecraft.bukkit.`object`.BukkitObjectMapper
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.io.File

@Service
class CraftFightService(
    private val plugin: JavaPlugin
) {

    @get:Bean
    var config: PluginConfig = PluginConfig()

    @get:Bean
    var lang: LangConfig = LangConfig()

    private val mapper: BukkitObjectMapper = BukkitObjectMapper()

    @PostConstruct
    fun start() {
        config = mapper.decode(
            YamlConfiguration.loadConfiguration(getConfigFile()).getValues(false),
            PluginConfig::class.java
        ).orThrow
        lang = mapper.decode(
            YamlConfiguration.loadConfiguration(getLangFile()).getValues(false),
            LangConfig::class.java
        ).orThrow
    }

    @PreDestroy
    fun stop() {
        YamlConfiguration().apply {
            mapper.encode(config).getOrElse(mapOf()).forEach { set(it.key, it.value) }
        }.save(getConfigFile())
        YamlConfiguration().apply {
            mapper.encode(lang).getOrElse(mapOf()).forEach { set(it.key, it.value) }
        }.save(getLangFile())
    }

    private fun getConfigFile(): File = File(plugin.dataFolder, "config.yml")
    private fun getLangFile(): File = File(plugin.dataFolder, "lang.yml")
}