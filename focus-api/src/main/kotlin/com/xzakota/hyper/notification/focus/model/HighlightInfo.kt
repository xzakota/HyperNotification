package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class HighlightInfo : TextAndColorInfo(), ITimerInfoCreator {
    var type : Int? = null
    var picFunction : String? = null
    var picFunctionDark : String? = null
    override var timerInfo : TimerInfo? = null
}
