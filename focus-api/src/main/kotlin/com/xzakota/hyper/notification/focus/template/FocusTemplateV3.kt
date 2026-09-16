@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.template

import com.xzakota.hyper.notification.focus.model.ActionInfo
import com.xzakota.hyper.notification.focus.model.AnimTextInfo
import com.xzakota.hyper.notification.focus.model.CoverInfo
import com.xzakota.hyper.notification.focus.model.HighlightInfoV3
import com.xzakota.hyper.notification.focus.model.IconTextInfo
import com.xzakota.hyper.notification.focus.model.MultiProgressInfo
import com.xzakota.hyper.notification.island.template.IIslandTemplateCreator
import com.xzakota.hyper.notification.island.template.IslandTemplate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class FocusTemplateV3 : FocusTemplate(), IExtraV3Param, IIslandTemplateCreator {
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

    /**
     * 封面组件
     */
    var coverInfo : CoverInfo? = null

    /**
     * 按钮组件
     */
    var highlightInfoV3 : HighlightInfoV3? = null

    /**
     * 图文组件
     */
    var iconTextInfo : IconTextInfo? = null

    /**
     * 进度组件
     */
    var multiProgressInfo : MultiProgressInfo? = null

    /**
     * 动画文本组件
     */
    var animTextInfo : AnimTextInfo? = null

    /**
     * 按钮组件
     */
    var textButton : ArrayList<ActionInfo>? = null

    @SerialName("param_island")
    override var island : IslandTemplate? = null

    override fun copyFrom(from : Any) {
        super.copyFrom(from)
        if (from is FocusTemplateV3) {
            from.coverInfo?.let { coverInfo = it }
            from.highlightInfoV3?.let { highlightInfoV3 = it }
            from.iconTextInfo?.let { iconTextInfo = it }
            from.multiProgressInfo?.let { multiProgressInfo = it }
            from.animTextInfo?.let { animTextInfo = it }
            from.textButton?.let { textButton = it }
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

    fun coverInfo(block : CoverInfo.() -> Unit) {
        val info = coverInfo ?: CoverInfo().also { coverInfo = it }
        info.apply(block)
    }

    fun highlightInfoV3(block : HighlightInfoV3.() -> Unit) {
        val info = highlightInfoV3 ?: HighlightInfoV3().also { highlightInfoV3 = it }
        info.apply(block)
    }

    fun iconTextInfo(block : IconTextInfo.() -> Unit) {
        val info = iconTextInfo ?: IconTextInfo().also { iconTextInfo = it }
        info.apply(block)
    }

    fun multiProgressInfo(block : MultiProgressInfo.() -> Unit) {
        val info = multiProgressInfo ?: MultiProgressInfo().also { multiProgressInfo = it }
        info.apply(block)
    }

    fun animTextInfo(block : AnimTextInfo.() -> Unit) {
        val info = animTextInfo ?: AnimTextInfo().also { animTextInfo = it }
        info.apply(block)
    }

    fun textButton(block : ArrayList<ActionInfo>.() -> Unit) {
        val info = textButton ?: arrayListOf<ActionInfo>().also { textButton = it }
        info.apply(block)
    }

    private fun getNotificationType() : String {
        val isShowNotification = isShowNotification == true
        val updatable = updatable == true

        return if (isShowNotification && updatable) {
            "持续更新通知"
        } else if (isShowNotification) {
            "一次性通知"
        } else if (updatable) {
            "持续服务提醒"
        } else {
            "一次性设备提醒"
        }
    }
}