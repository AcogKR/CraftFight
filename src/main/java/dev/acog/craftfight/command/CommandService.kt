package dev.acog.craftfight.command

import dev.acog.craftfight.domain.Area
import dev.acog.craftfight.service.AreaService
import io.heartpattern.springfox.paper.core.SpringFoxPlugin
import io.typecraft.command.Argument
import io.typecraft.command.Command
import io.typecraft.command.Command.pair
import io.typecraft.command.StandardArguments.strArg
import io.typecraft.command.bukkit.BukkitCommands
import jakarta.annotation.PostConstruct
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class CommandService(
    private val plugin: SpringFoxPlugin,
    private val areaService: AreaService
) {

    private val areaArg: Argument<Area> =
        Argument.ofUnary(
            "area",
            { s -> Optional.ofNullable(areaService.getArea(s)) },
            { areaService.getAreaList() }
        )


    private fun managerCommandExecute(sender: CommandSender, command: ManagerCommand) {
        if(sender !is Player) {
            sender.sendMessage("플레이어만 명령어 사용이 가능합니다.")
            return
        }
        command.executor(sender, plugin)
    }

    private val managerCommandNode: Command<ManagerCommand>
        get() = Command.mapping(
            pair("지역", Command.mapping(
                pair("생성", Command.argument(ManagerCommand::AreaCreate, strArg)),
                pair("목록", Command.argument(ManagerCommand::AreaList)),
                pair("관리", Command.mapping(
                    pair("위치1", Command.argument(ManagerCommand::AreaSetFirstLocation, areaArg)),
                    pair("위치2", Command.argument(ManagerCommand::AreaSetSecondLocation, areaArg)),
                    pair("관전", Command.argument(ManagerCommand::AreaSetSpectatorLocation, areaArg))
                ).withFallback(Command.argument(ManagerCommand::AreaSettingView, areaArg)))
            )),
            pair("유저", Command.mapping(
                pair("", )
            )),
            pair("시스템", Command.mapping(
                pair("랭크표", Command.mapping(

                )),
                pair("리더보드", Command.mapping(

                ))
            ))
        )

    private fun userCommandExecute(sender: CommandSender, command: UserCommand) {
        if(sender !is Player) {
            sender.sendMessage("플레이어만 명령어 사용이 가능합니다.")
            return
        }
        command.executor(sender, plugin)
    }

    private val userCommandNode: Command<UserCommand>
        get() = Command.mapping(

        )

    @PostConstruct
    fun registerCommand() {
        BukkitCommands.register(
            "대전관리",
            managerCommandNode,
            ::managerCommandExecute,
            plugin
        )
        BukkitCommands.register(
            "대전",
            userCommandNode,
            ::userCommandExecute,
            plugin
        )
    }

}