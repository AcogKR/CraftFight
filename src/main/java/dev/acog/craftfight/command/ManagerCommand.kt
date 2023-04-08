package dev.acog.craftfight.command

import dev.acog.craftfight.configuration.LangConfig
import dev.acog.craftfight.configuration.PluginConfig
import dev.acog.craftfight.library.CommandException
import dev.acog.craftfight.library.getOrStop
import dev.acog.craftfight.library.stop
import dev.acog.craftfight.service.AreaService
import dev.acog.craftfight.service.UserService
import io.heartpattern.springfox.paper.command.annotation.CommandHandler
import io.heartpattern.springfox.paper.command.model.CommandInvocation
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.stereotype.Component

@Component
class ManagerCommand(
    val plugin: JavaPlugin,
    val config: PluginConfig,
    val lang: LangConfig,
    val areaService: AreaService,
    val userService: UserService
) {

    @CommandHandler(name = ["CraftFight"])
    fun execute(invocation: CommandInvocation) {
        runCatching {
            val player: Player =
                if (invocation.sender is Player) invocation.sender as Player
                else stop("해당 명령어는 플레이어만 사용할수 있습니다.")
            val command = invocation.args.getOrStop(0, "/CraftFight help")

            when (command) {
                "test" -> {

                }
            }
        }.recoverCatching { exception ->
            when (exception) {
                is CommandException -> invocation.sender.sendMessage(exception.message ?: "throw Exception")
            }
        }
    }
}