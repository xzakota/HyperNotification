package com.xzakota.hyper.notification.focus.template

import com.xzakota.hyper.notification.island.template.IIslandTemplateCreator
import com.xzakota.hyper.notification.island.template.IslandTemplate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class CustomFocusTemplateV3 : CustomFocusTemplate(), IExtraV3Param, IIslandTemplateCreator {
    override var sequence : Long? = null
    override var cancel : Boolean? = null
    override var hideDeco : Boolean? = null
    override var isShowNotification : Boolean? = null
    override var islandFirstFloat : Boolean? = null
    override var notifyId : String? = null
    override var orderId : String? = null
    override var outEffectColor : String? = null
    override var outEffectSrc : String? = null
    override var business : String? = null

    @SerialName("param_island")
    override var island : IslandTemplate? = null

    override fun copyFrom(from : Any) {
        super.copyFrom(from)
        reflectCollect(from, CustomFocusTemplateV3::class.java)
    }

    @Suppress("ClassName")
    companion object `Companion-Object` {
        const val LAYOUT_ISLAND_EXPAND = "miui.focus.rv.island.expand"
    }
}
