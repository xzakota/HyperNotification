package com.xzakota.hyper.notification.focus.util

import android.annotation.SuppressLint
import java.lang.reflect.Method

@SuppressLint("PrivateApi")
object PropUtils {
    private val getBooleanMethod : Method? by lazy {
        runCatching {
            Class.forName("android.os.SystemProperties")
                .getDeclaredMethod("getBoolean", String::class.java, Boolean::class.javaPrimitiveType)
        }.getOrNull()
    }

    @JvmStatic
    fun getBoolean(key : String, defValue : Boolean) : Boolean = runCatching {
        getBooleanMethod?.invoke(null, key, defValue) as? Boolean
    }.getOrNull() ?: defValue
}
