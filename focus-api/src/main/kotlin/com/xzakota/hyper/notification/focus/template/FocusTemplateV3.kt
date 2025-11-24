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
     * 封⾯组件
     */
    var coverInfo : CoverInfo? = null

    /**
     * 按钮组件
     */
    var highlightInfoV3 : HighlightInfoV3? = null

    /**
     * 图⽂组件
     */
    var iconTextInfo : IconTextInfo? = null

    /**
     * 进度组件
     */
    var multiProgressInfo : MultiProgressInfo? = null

    /**
     * 动画⽂本组件
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