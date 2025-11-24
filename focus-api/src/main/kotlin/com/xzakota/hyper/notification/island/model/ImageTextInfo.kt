package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable

@Serializable
class ImageTextInfo : ITextInfoCreator, IPicInfoCreator, IProgressInfoCreator {
    /**
     * 图⽂组件类型
     * - `1`
     * - `2`
     * - `3`
     * - `4`
     * - `5`
     * - `6`
     */
    var type : Int? = null

    override var textInfo : TextInfo? = null
    override var picInfo : PicInfo? = null
    override var progressInfo : ProgressInfo? = null
}
