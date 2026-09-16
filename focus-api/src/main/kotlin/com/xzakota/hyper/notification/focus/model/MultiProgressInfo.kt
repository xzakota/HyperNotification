package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@Suppress("unused")
@FocusNotificationDsl
@Serializable
class MultiProgressInfo : TextAndColorInfo() {
    /**
     * 当前进度
     */
    var progress : Int? = null

    /**
     * 进度条颜色
     */
    var color : String? = null

    /**
     * 节点数量
     * - 范围: 0 ~ 4
     */
    var points : Int? = null
}
