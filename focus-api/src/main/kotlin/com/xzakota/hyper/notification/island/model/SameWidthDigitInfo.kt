package com.xzakota.hyper.notification.island.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class SameWidthDigitInfo : ITimerInfoCreator {
    var timerType : String? = null
    var digit : String? = null
    var turnAnim : Boolean? = null
    var showHighlightColor : Boolean? = null
    override var timerInfo : TimerInfo? = null
}
