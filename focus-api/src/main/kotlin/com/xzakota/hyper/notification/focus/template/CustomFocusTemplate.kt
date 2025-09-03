package com.xzakota.hyper.notification.focus.template

import android.widget.RemoteViews
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Suppress("unused")
@Serializable
open class CustomFocusTemplate : BaseFocusTemplate() {
    @Transient
    internal var rv = mutableMapOf<String, RemoteViews?>()

    fun createRemoteViews(key : String, value : RemoteViews?) {
        if (value != null) {
            rv[key] = value
        }
    }

    @Suppress("ClassName")
    companion object `Companion-Object` {
        const val LAYOUT = "miui.focus.rv"
        const val LAYOUT_NIGHT = "miui.focus.rvNight"
        const val LAYOUT_AOD = "miui.focus.rvAod"
        const val LAYOUT_FLIP_TINY = "miui.focus.rv.tiny"
        const val LAYOUT_FLIP_TINY_NIGHT = "miui.focus.rv.tinyNight"
        const val LAYOUT_DECO_LAND = "miui.focus.rv.deco.land"
        const val LAYOUT_DECO_LAND_NIGHT = "miui.focus.rv.deco.land.night"
        const val LAYOUT_DECO_PORT = "miui.focus.rv.deco.port"
        const val LAYOUT_DECO_PORT_NIGHT = "miui.focus.rv.deco.port.night"
    }
}
