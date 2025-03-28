package com.xzakota.hyper.notification.focus.util

import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

@Suppress("unused")
internal object JSONUtils {
    @JvmField
    val json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    @JvmStatic
    inline fun <reified T> parseObjectOrNull(text : String) : T? = runCatching {
        parseObject<T>(text)
    }.getOrNull()

    @JvmStatic
    inline fun <reified T> parseObject(text : String) : T = json.decodeFromString(text)

    @JvmStatic
    inline fun <reified T> toJSONString(
        value : T,
        serializer : SerializationStrategy<T> = serializer()
    ) : String = json.encodeToString(serializer, value)
}
