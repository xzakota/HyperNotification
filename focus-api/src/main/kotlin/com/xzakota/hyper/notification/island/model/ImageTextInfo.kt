package com.xzakota.hyper.notification.island.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@FocusNotificationDsl
@Serializable
class ImageTextInfo : ITextInfoCreator, IPicInfoCreator, IProgressInfoCreator {
    /**
     * 图文组件类型
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
