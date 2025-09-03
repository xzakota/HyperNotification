package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class ChatInfo : TextAndColorInfo(), ITimerInfoCreator {
    var picProfile : String? = null
    override var timerInfo : TimerInfo? = null
}
