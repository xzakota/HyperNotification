package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class HintInfo : TextAndColorInfo(), ITimerInfoCreator, IActionInfoCreator {
    var type : Int? = null
    var titleLineCount : Int? = null
    var colorContentBg : String? = null
    var picContent : String? = null
    override var timerInfo : TimerInfo? = null
    override var actionInfo : ActionInfo? = null
}
