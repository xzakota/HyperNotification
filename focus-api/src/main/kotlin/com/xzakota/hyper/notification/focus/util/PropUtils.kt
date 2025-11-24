package com.xzakota.hyper.notification.focus.util

object PropUtils {
    @JvmStatic
    fun getBoolean(key: String, defValue: Boolean): Boolean = runCatching {
        Class.forName("android.os.SystemProperties")
            .getDeclaredMethod("getBoolean", String::class.java, Boolean::class.javaPrimitiveType)
            .invoke(null, key, false) as Boolean
    }.getOrDefault(defValue)
}