package dev.acog.craftfight.service

import dev.acog.craftfight.CraftFightService
import dev.acog.craftfight.domain.Area
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.stereotype.Service
import java.io.File

@Service
class AreaService(
    private val plugin: JavaPlugin,
    private val craftService: CraftFightService
) {

    private var areas: Map<String, Area> = mutableMapOf()

    @PostConstruct
    fun load() {
    }

    @PreDestroy
    fun save() {
    }

    private fun getAreaConfig() : File = File(plugin.dataFolder, "area.yml")

}
