package dev.acog.craftfight.configuration.converter

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.bukkit.Location

class LocationSerializer : JsonSerializer<Location>() {
    override fun serialize(value: Location, gen: JsonGenerator, provider: SerializerProvider) {
        gen.run {
            writeStartObject()
            writeStringField("world", value.world.name)
            writeNumberField("x", value.x)
            writeNumberField("y", value.y)
            writeNumberField("z", value.z)

            writeNumberField("pitch", value.pitch)
            writeNumberField("yaw", value.yaw)
        }
    }
}