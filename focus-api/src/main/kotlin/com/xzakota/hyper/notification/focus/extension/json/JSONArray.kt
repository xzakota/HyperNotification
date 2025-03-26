@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.extension.json

import org.json.JSONArray

val JSONArray.indices : IntRange
    @JvmSynthetic get() = 0 until length()

operator fun JSONArray.set(index : Int, value : Any?) {
    put(index, value)
}

inline fun JSONArray.forEach(action : (view : Any) -> Unit) {
    for (index in indices) {
        action(get(index))
    }
}
