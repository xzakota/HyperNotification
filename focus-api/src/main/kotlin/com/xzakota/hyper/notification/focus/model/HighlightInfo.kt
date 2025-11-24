package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class HighlightInfo : TextAndColorInfo(), ITimerInfoCreator {
    /**
     * ⽂本组件类型
     * - `0` 显示次要文本
     * - `1` 隐藏次要⽂本
     */
    var type : Int? = null

    /**
     * 浅色模式功能图标
     */
    var picFunction : String? = null

    /**
     * 深色模式功能图标
     */
    var picFunctionDark : String? = null

    override var timerInfo : TimerInfo? = null
}
