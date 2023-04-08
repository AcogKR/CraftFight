package dev.acog.craftfight.domain

import java.math.BigDecimal
import java.util.UUID

data class User(
    val id: UUID,
    val name: String,

    val win: Long,
    val lose: Long,
    val draw: Long,

    val score: BigDecimal
)
