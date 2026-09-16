package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@FocusNotificationDsl
@Serializable
class AnimTextInfo : TextAndColorInfo(), IAnimIconInfoCreator, ITimerInfoCreator {
    override var animIconInfo : AnimIconInfo? = null
    override var timerInfo : TimerInfo? = null
}
