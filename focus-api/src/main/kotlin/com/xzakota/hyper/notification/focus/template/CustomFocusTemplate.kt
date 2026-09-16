package com.xzakota.hyper.notification.focus.template

import android.os.Bundle
import android.widget.RemoteViews
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Suppress("unused")
@Serializable
open class CustomFocusTemplate : BaseFocusTemplate() {
    @Transient
    private var viewMap : MutableMap<String, RemoteViews?>? = null

    internal fun handleRemoteViewsIn(bundle: Bundle) = with(bundle) {
        viewMap?.forEach { (k, v) ->
            putParcelable(k, v)
        }
    }

    fun createRemoteViews(key : String, value : RemoteViews?) {
        if (value == null) {
            return
        }

        val map = viewMap ?: mutableMapOf<String, RemoteViews?>().also { viewMap = it }
        map[key] = value
    }

    companion object {
        const val LAYOUT = "miui.focus.rv"
        const val LAYOUT_NIGHT = "miui.focus.rvNight"
        const val LAYOUT_AOD = "miui.focus.rvAod"
        const val LAYOUT_FULL_AOD = "miui.focus.rv.fullAod"
        const val LAYOUT_FLIP_TINY = "miui.focus.rv.tiny"
        const val LAYOUT_FLIP_TINY_NIGHT = "miui.focus.rv.tinyNight"
        const val LAYOUT_DECO_LAND = "miui.focus.rv.deco.land"
        const val LAYOUT_DECO_LAND_NIGHT = "miui.focus.rv.deco.land.night"
        const val LAYOUT_DECO_PORT = "miui.focus.rv.deco.port"
        const val LAYOUT_DECO_PORT_NIGHT = "miui.focus.rv.deco.port.night"
    }
}
