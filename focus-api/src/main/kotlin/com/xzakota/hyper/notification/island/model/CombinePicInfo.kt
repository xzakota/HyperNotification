package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Suppress("unused")
@Serializable
class CombinePicInfo : IPicInfoCreator, IProgressInfoCreator {
    override var picInfo : PicInfo? = null
    var smallPicInfo : PicInfo? = null
    override var progressInfo : ProgressInfo? = null

    fun smallPicInfo(consumer : Consumer<PicInfo>) = smallPicInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun smallPicInfo(block : PicInfo.() -> Unit) {
        val info = smallPicInfo ?: PicInfo().also { smallPicInfo = it }
        info.apply(block)
    }
}
