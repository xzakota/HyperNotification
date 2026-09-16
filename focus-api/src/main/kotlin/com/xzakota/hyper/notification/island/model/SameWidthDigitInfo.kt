package com.xzakota.hyper.notification.island.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@FocusNotificationDsl
@Serializable
class SameWidthDigitInfo : DigitInfo(), ITimerInfoCreator {
    override var timerInfo : TimerInfo? = null
}
