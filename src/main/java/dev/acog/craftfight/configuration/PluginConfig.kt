package dev.acog.craftfight.configuration

import lombok.Builder

@Builder
class PluginConfig(
    val allowCommands: MutableList<String> = mutableListOf(
        "/대전 종료",
        "/대전 전적"
    )
)