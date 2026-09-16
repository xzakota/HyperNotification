package com.xzakota.hyper.notification.island.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@Suppress("unused")
@FocusNotificationDsl
@Serializable
class SmallIslandArea : IPicInfoCreator {
    override var picInfo : PicInfo? = null

    /**
     * 图标组合组件
     */
    var combinePicInfo : CombinePicInfo? = null

    fun combinePicInfo(block : CombinePicInfo.() -> Unit) {
        val info = combinePicInfo ?: CombinePicInfo().also { combinePicInfo = it }
        info.apply(block)
    }
}
