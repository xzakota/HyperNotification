@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@FocusNotificationDsl
@Serializable
class AnimIconInfo : TextAndColorInfo() {
    /**
     * 类型
     * - `0` (默认值) 静态图
     * - `1`
     * - `2`
     */
    var type : Int? = null

    var number : Int? = null
    var src : String? = null
    var srcDark : String? = null
    var effectSrc : String? = null
    var effectColor : String? = null
    var autoplay : Boolean? = null
    var loop : Boolean? = null
}

internal interface IAnimIconInfoCreator {
    /**
     * 动画属性参数
     */
    var animIconInfo : AnimIconInfo?

    fun animIconInfo(block : AnimIconInfo.() -> Unit) {
        val info = animIconInfo ?: AnimIconInfo().also { animIconInfo = it }
        info.apply(block)
    }
}
