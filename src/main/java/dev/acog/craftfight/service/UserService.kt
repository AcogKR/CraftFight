package dev.acog.craftfight.service

import dev.acog.craftfight.CraftFightService
import dev.acog.craftfight.domain.User
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.stereotype.Service
import java.io.File
import java.util.UUID

@Service
class UserService(
    private val plugin: JavaPlugin,
    private val craftService: CraftFightService
) {

    private var users: Map<UUID, User> = mutableMapOf()

    @PostConstruct // 이 두개는 YamlConfiguration 을 사용해서 sava or load 만들기
    fun load() {
    }

    @PreDestroy
    fun save() {
    }

    private fun getAreaConfig() : File = File(plugin.dataFolder, "user.yml")

}