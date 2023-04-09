package dev.acog.craftfight.command

import dev.acog.craftfight.domain.Area
import io.typecraft.command.Command
import io.typecraft.command.Command.pair
import io.typecraft.command.StandardArguments.strArg
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.beans.factory.annotation.Autowired

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
}