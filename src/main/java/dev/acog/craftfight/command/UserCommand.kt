package dev.acog.craftfight.command

import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

interface UserCommand {

    fun executor(player: Player, plugin: JavaPlugin)

}