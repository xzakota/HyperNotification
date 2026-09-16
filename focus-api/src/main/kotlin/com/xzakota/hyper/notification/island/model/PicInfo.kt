@file:Suppress("unused")

package com.xzakota.hyper.notification.island.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@FocusNotificationDsl
@Serializable
class PicInfo {
    /**
     * 类型
     * - `0` (默认值) 静态图
     * - `1`
     * - `2`
     * - `3`
     * - `4`
     * - `5`
     */
    var type : Int? = null

    var contentDescription : String? = null
    var number : Int? = null
    var pic : String? = null
    var effectSrc : String? = null
    var effectColor : String? = null
    var autoplay : Boolean? = null
    var loop : Boolean? = null
}

internal interface IPicInfoCreator {
    /**
     * 图标属性参数
     */
    var picInfo : PicInfo?

    fun picInfo(block : PicInfo.() -> Unit) {
        val info = picInfo ?: PicInfo().also { picInfo = it }
        info.apply(block)
    }
}
