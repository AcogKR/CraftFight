package dev.acog.craftfight.service

import dev.acog.craftfight.domain.Area
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.stereotype.Service

@Service
class AreaService(
    private val plugin: JavaPlugin
) {

    fun getArea(name: String) : Area = TODO()

    fun getAreaList() : MutableList<String> = TODO()
}
