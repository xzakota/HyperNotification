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
import java.util.function.Consumer

@Serializable
class FocusTemplateV3 : FocusTemplate(), IExtraV3Param, IIslandTemplateCreator {
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

    var coverInfo : CoverInfo? = null
    var highlightInfoV3 : HighlightInfoV3? = null
    var iconTextInfo : IconTextInfo? = null
    var multiProgressInfo : MultiProgressInfo? = null
    var animTextInfo : AnimTextInfo? = null
    var textButton : ArrayList<ActionInfo>? = null

    @SerialName("param_island")
    override var island : IslandTemplate? = null

    override fun copyFrom(from : Any) {
        super.copyFrom(from)
        reflectCollect(from, FocusTemplateV3::class.java)
    }

    fun highlightInfoV3(consumer : Consumer<HighlightInfoV3>) = highlightInfoV3 {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun highlightInfoV3(block : HighlightInfoV3.() -> Unit) {
        val info = highlightInfoV3 ?: HighlightInfoV3().also { highlightInfoV3 = it }
        info.apply(block)
    }

    fun iconTextInfo(consumer : Consumer<IconTextInfo>) = iconTextInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun iconTextInfo(block : IconTextInfo.() -> Unit) {
        val info = iconTextInfo ?: IconTextInfo().also { iconTextInfo = it }
        info.apply(block)
    }

    fun multiProgressInfo(consumer : Consumer<MultiProgressInfo>) = multiProgressInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun multiProgressInfo(block : MultiProgressInfo.() -> Unit) {
        val info = multiProgressInfo ?: MultiProgressInfo().also { multiProgressInfo = it }
        info.apply(block)
    }

    fun animTextInfo(consumer : Consumer<AnimTextInfo>) = animTextInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun animTextInfo(block : AnimTextInfo.() -> Unit) {
        val info = animTextInfo ?: AnimTextInfo().also { animTextInfo = it }
        info.apply(block)
    }

    fun textButton(consumer : Consumer<ArrayList<ActionInfo>>) = textButton {
        consumer.accept(this)
    }

    @JvmSynthetic
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