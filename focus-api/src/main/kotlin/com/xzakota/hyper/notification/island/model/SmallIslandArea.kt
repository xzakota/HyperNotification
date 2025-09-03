package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Suppress("unused")
@Serializable
class SmallIslandArea : IPicInfoCreator {
    override var picInfo : PicInfo? = null
    var combinePicInfo : CombinePicInfo? = null

    fun combinePicInfo(consumer : Consumer<CombinePicInfo>) = combinePicInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun combinePicInfo(block : CombinePicInfo.() -> Unit) {
        val info = combinePicInfo ?: CombinePicInfo().also { combinePicInfo = it }
        info.apply(block)
    }
}
