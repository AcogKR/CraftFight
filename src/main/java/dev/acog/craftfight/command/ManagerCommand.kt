package dev.acog.craftfight.command

import dev.acog.craftfight.domain.Area
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

interface ManagerCommand {

    fun executor(player: Player, plugin: JavaPlugin)

    class AreaCreate(
        private val areaName: String
    ) : ManagerCommand {

        override fun executor(player: Player, plugin: JavaPlugin) {
            TODO("Not yet implemented")
        }

    }

    class AreaList(
    ) : ManagerCommand {

        override fun executor(player: Player, plugin: JavaPlugin) {
            TODO("Not yet implemented")
        }

    }

    class AreaSetFirstLocation(
        private val area: Area
    ) : ManagerCommand {

        override fun executor(player: Player, plugin: JavaPlugin) {
            TODO("Not yet implemented")
        }

    }

    class AreaSetSecondLocation(
        private val area: Area
    ) : ManagerCommand {

        override fun executor(player: Player, plugin: JavaPlugin) {
            TODO("Not yet implemented")
        }

    }

    class AreaSetSpectatorLocation(
        private val area: Area
    ) : ManagerCommand {

        override fun executor(player: Player, plugin: JavaPlugin) {
            TODO("Not yet implemented")
        }

    }

    class AreaSettingView(
        private val area: Area
    ) : ManagerCommand {

        override fun executor(player: Player, plugin: JavaPlugin) {
            TODO("Not yet implemented")
        }

    }

}