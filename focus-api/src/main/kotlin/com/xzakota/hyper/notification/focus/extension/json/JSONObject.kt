@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.extension.json

import org.json.JSONArray
import org.json.JSONObject

operator fun JSONObject.set(key : String, value : Any?) {
    put(key, value)
}

operator fun JSONObject.minus(key : String) : Any? = remove(key)
operator fun JSONObject.minusAssign(key : String) {
    minus(key)
}

fun JSONObject.putAll(map : Map<String, Any?>?) {
    map?.forEach { (k, v) ->
        if (v != null) {
            put(k, v)
        }
    }
}

fun JSONObject.forEach(action : (String, Any?) -> Unit) {
    keys().forEach {
        action(it, get(it))
    }
}

fun JSONObject.getOrPut(key : String, defaultValue : JSONObject.() -> Any?) : Any? = if (has(key)) {
    get(key)
} else {
    val value = defaultValue()
    put(key, value)
    value
}

fun JSONObject.getOrDef(key : String, defaultValue : Any? = null) : Any? = if (has(key)) {
    get(key)
} else {
    defaultValue
}

fun JSONObject.getIntOrDef(key : String, defaultValue : Int = 0) : Int = if (has(key)) {
    getInt(key)
} else {
    defaultValue
}

fun JSONObject.getDoubleOrDef(key : String, defaultValue : Double = 0.0) : Double = if (has(key)) {
    getDouble(key)
} else {
    defaultValue
}

fun JSONObject.getBooleanOrDef(key : String, defaultValue : Boolean = false) : Boolean = if (has(key)) {
    getBoolean(key)
} else {
    defaultValue
}

fun JSONObject.getStringOrDef(key : String, defaultValue : String? = null) : String? = if (has(key)) {
    getString(key)
} else {
    defaultValue
}

fun JSONObject.getJSONArrayOrDef(key : String, defaultValue : JSONArray? = null) : JSONArray? = if (has(key)) {
    getJSONArray(key)
} else {
    defaultValue
}

fun JSONObject.getJSONObjectOrDef(key : String, defaultValue : JSONObject? = null) : JSONObject? = if (has(key)) {
    getJSONObject(key)
} else {
    defaultValue
}
