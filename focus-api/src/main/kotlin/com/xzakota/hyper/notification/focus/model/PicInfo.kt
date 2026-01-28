package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class PicInfo : IActionInfoCreator {
    /**
     * 类型
     * - `0` (默认值) 静态图
     */
    var type : Int? = null

    /**
     * 浅色模式 的 应用图标/功能图标/图片
     */
    var pic : String? = null

    /**
     * 深色模式 的 应用图标/功能图标/图片
     */
    var picDark : String? = null

    override var actionInfo : ActionInfo? = null
}
