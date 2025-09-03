package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class ImageTextInfo : ITextInfoCreator, IPicInfoCreator, IProgressInfoCreator {
    var type : Int? = null
    override var textInfo : TextInfo? = null
    override var picInfo : PicInfo? = null
    override var progressInfo : ProgressInfo? = null
}
