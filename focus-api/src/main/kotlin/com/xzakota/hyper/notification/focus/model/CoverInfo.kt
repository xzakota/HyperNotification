package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class CoverInfo : TextAndColorInfo() {
    /**
     * 封⾯图
     * - 位置: 和⽂本整体纵向居中
     */
    var picCover : String? = null
}
