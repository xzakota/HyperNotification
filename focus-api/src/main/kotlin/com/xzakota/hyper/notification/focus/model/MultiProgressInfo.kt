package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class MultiProgressInfo : TextAndColorInfo() {
    /**
     * 当前进度
     */
    var progress : Int? = null

    /**
     * 进度条颜⾊
     */
    var color : String? = null

    /**
     * 节点数量(0 - 4)
     */
    var points : Int? = null
}
