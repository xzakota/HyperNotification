package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class BgInfo {
    /**
     * 背景类型
     * - `1` (默认值) 全屏
     * - `2` 右侧
     */
    var type : Int? = null

    /**
     * 背景色
     */
    var colorBg : String? = null

    /**
     * 背景图
     */
    var picBg : String? = null
}
