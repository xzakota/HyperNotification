@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class ActionInfo : IProgressInfoCreator {
    /**
     * 按钮类型
     * - `0` (默认值) 圆形按钮类型
     * - `1` 进度按钮类型
     * - `2` ⽂字按钮类型
     */
    var type: Int? = null

    /**
     * 从 createAction 创建的 action
     */
    var action : String? = null

    /**
     * ⾃定义构建 action
     */
    var actionIntent : String? = null

    /**
     * 跳转 URI 类型
     * - `1` url to activity
     * - `2` action to broadcast
     * - `3` action to service
     */
    var actionIntentType : Int? = null

    var actionIcon : String? = null
    var actionIconDark : String? = null
    var actionTitle : String? = null
    var actionTitleColor : String? = null
    var actionTitleColorDark : String? = null
    var actionBgColor : String? = null
    var actionBgColorDark : String? = null

    /**
     * 点击是否收起⾯板
     * - 1. Action 的 PendingIntent 是 Activity 类型, 默认点击收起
     * - 2. actionIntentType 为 1 时, 默认点击收起
     */
    var clickWithCollapse : Boolean? = null

    override var progressInfo : ProgressInfo? = null
}

internal interface IActionInfoCreator {
    /**
     * 动作属性参数
     */
    var actionInfo : ActionInfo?

    fun actionInfo(consumer : Consumer<ActionInfo>) = actionInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun actionInfo(block : ActionInfo.() -> Unit) {
        val info = actionInfo ?: ActionInfo().also { actionInfo = it }
        info.apply(block)
    }
}
