package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class ChatInfo : TextAndColorInfo(), ITimerInfoCreator {
    /**
     * 浅色模式头像类⼩图
     */
    var picProfile : String? = null

    /**
     * 深色模式头像类⼩图
     */
    var picProfileDark : String? = null

    /**
     * ⾃定义应⽤图标
     */
    var appIconPkg : String? = null

    override var timerInfo : TimerInfo? = null
}
