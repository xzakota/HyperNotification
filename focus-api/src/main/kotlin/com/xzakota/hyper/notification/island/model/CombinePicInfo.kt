package com.xzakota.hyper.notification.island.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@Suppress("unused")
@FocusNotificationDsl
@Serializable
class CombinePicInfo : IPicInfoCreator, IProgressInfoCreator {
    /**
     * 小图标
     */
    var smallPicInfo : PicInfo? = null

    override var picInfo : PicInfo? = null
    override var progressInfo : ProgressInfo? = null

    fun smallPicInfo(block : PicInfo.() -> Unit) {
        val info = smallPicInfo ?: PicInfo().also { smallPicInfo = it }
        info.apply(block)
    }
}
