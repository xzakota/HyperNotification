package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@Suppress("unused")
@FocusNotificationDsl
@Serializable
class CoverInfo : TextAndColorInfo() {
    /**
     * 封面图
     * - 位置: 和文本整体纵向居中
     */
    var picCover : String? = null
}
