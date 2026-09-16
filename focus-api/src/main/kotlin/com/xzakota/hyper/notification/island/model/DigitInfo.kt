package com.xzakota.hyper.notification.island.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@Suppress("unused")
@FocusNotificationDsl
@Serializable
abstract class DigitInfo {
    /**
     * 小字
     */
    var content : String? = null

    /**
     * 定宽/等宽数字
     */
    var digit : String? = null

    /**
     * 是否使用强调色
     */
    var showHighlightColor : Boolean? = null

    var turnAnim : Boolean? = null
}
