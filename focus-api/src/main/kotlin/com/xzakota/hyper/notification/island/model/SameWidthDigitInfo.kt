package com.xzakota.hyper.notification.island.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import kotlinx.serialization.Serializable

@Serializable
class SameWidthDigitInfo : DigitInfo(), ITimerInfoCreator {
    override var timerInfo : TimerInfo? = null
}
