package com.xzakota.hyper.notification.focus.template

import com.xzakota.hyper.notification.island.template.IIslandTemplateCreator
import com.xzakota.hyper.notification.island.template.IslandTemplate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CustomFocusTemplateV3 : CustomFocusTemplate(), IExtraV3Param, IIslandTemplateCreator {
    override var cancel : Boolean? = null
    override var isShowNotification : Boolean? = null
    override var islandFirstFloat : Boolean? = null
    override var hideDeco : Boolean? = null
    override var outEffectColor : String? = null
    override var outEffectSrc : String? = null
    override var sequence : Long? = null
    override var business : String? = null
    override var notifyId : String? = null
    override var orderId : String? = null

    @SerialName("param_island")
    override var island : IslandTemplate? = null

    override fun copyFrom(from : Any) {
        super.copyFrom(from)
        if (from is CustomFocusTemplateV3) {
            from.island?.let { island = it }
            from.cancel?.let { cancel = it }
            from.hideDeco?.let { hideDeco = it }
            from.isShowNotification?.let { isShowNotification = it }
            from.islandFirstFloat?.let { islandFirstFloat = it }
            from.outEffectColor?.let { outEffectColor = it }
            from.outEffectSrc?.let { outEffectSrc = it }
            from.sequence?.let { sequence = it }
            from.business?.let { business = it }
            from.notifyId?.let { notifyId = it }
            from.orderId?.let { orderId = it }
        }
    }

    companion object {
        const val LAYOUT_ISLAND_EXPAND = "miui.focus.rv.island.expand"
    }
}
