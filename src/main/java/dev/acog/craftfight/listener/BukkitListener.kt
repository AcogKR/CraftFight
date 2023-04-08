package dev.acog.craftfight.listener

import dev.acog.craftfight.service.AreaService
import dev.acog.craftfight.service.UserService
import org.springframework.stereotype.Component

@Component
class BukkitListener(
    private val areaService: AreaService,
    private val userService: UserService
) {

}