package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@Suppress("unused")
@FocusNotificationDsl
@Serializable
class ChatInfo : TextAndColorInfo(), ITimerInfoCreator {
    /**
     * 浅色模式头像类小图
     */
    var picProfile : String? = null

    /**
     * 深色模式头像类小图
     */
    var picProfileDark : String? = null

    /**
     * 自定义应用图标
     */
    var appIconPkg : String? = null

    override var timerInfo : TimerInfo? = null
}
