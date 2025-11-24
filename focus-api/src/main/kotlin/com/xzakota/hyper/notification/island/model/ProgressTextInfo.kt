package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable

@Serializable
class ProgressTextInfo : ITextInfoCreator, IProgressInfoCreator {
    override var textInfo : TextInfo? = null
    override var progressInfo : ProgressInfo? = null
}
