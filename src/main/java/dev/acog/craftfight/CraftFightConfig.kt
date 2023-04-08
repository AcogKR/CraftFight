package dev.acog.craftfight

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator
import dev.acog.craftfight.configuration.ArenaConfig
import dev.acog.craftfight.configuration.LangConfig
import dev.acog.craftfight.configuration.PluginConfig
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

@Configuration
open class CraftFightConfig(
    private val plugin: JavaPlugin
) {

    @get:Bean
    open var config: PluginConfig = PluginConfig()

    @get:Bean
    open var lang: LangConfig = LangConfig()

    @get:Bean
    open var arena: ArenaConfig = ArenaConfig()

    @PostConstruct
    fun start() {
        val mapper = ObjectMapper(YAMLFactory())
        //config = mapper.readValue(getConfigFile(), PluginConfig::class.java)
        //lang = mapper.readValue(getLangFile(), LangConfig::class.java)
        //arena = mapper.readValue(getArenaFile(), ArenaConfig::class.java)
    }

    @PreDestroy
    fun stop() {
        ObjectMapper(YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)).run {
            writeValue(getConfigFile(), config)
            writeValue(getLangFile(), lang)
            writeValue(getArenaFile(), arena)
        }
    }

    private fun getConfigFile(): File = File(plugin.dataFolder, "config.yml")
    private fun getLangFile(): File = File(plugin.dataFolder, "lang.yml")
    private fun getArenaFile(): File = File(plugin.dataFolder, "arena.yml")
}
