package com.xzakota.hyper.notification.island.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@FocusNotificationDsl
@Serializable
class ProgressTextInfo : ITextInfoCreator, IProgressInfoCreator {
    override var textInfo : TextInfo? = null
    override var progressInfo : ProgressInfo? = null
}
