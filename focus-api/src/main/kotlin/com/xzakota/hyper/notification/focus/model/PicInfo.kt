package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class PicInfo : IActionInfoCreator {
    /**
     * 识别图形组件类型
     * - `1` appIcon
     * - `2` middle, 需设置 pic 属性
     * - `3` large, 需设置 pic 属性
     * - `5` 倒计时
     */
    var type : Int = 0

    /**
     * 浅色模式 应⽤图标/功能图标/图⽚
     */
    var pic : String? = null

    /**
     * 深色模式 应⽤图标/功能图标/图⽚
     */
    var picDark : String? = null

    override var actionInfo : ActionInfo? = null
}
