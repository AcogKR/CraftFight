package dev.acog.craftfight.library

import org.bukkit.ChatColor

inline fun <T> T.validate(error: String, validation: (T) -> Boolean): T = takeUnless(validation) ?: stop(error)

fun <T> T?.validateNull(error: String = ""): T = this ?: stop(error)

fun <T> List<T>.getOrStop(index: Int, error: String) : T = getOrNull(index) ?: stop(error)

fun stop(error: String): Nothing = throw CommandException(error.colorize())

fun String.colorize(altColorChar: Char = '&') = ChatColor.translateAlternateColorCodes(altColorChar, toString())

fun <T, V> Map<T, V>.getKey(value: V) : T? {
    return filter { it.value == value }.keys.first()
}
