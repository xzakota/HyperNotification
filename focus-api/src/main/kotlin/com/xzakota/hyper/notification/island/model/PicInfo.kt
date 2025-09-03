@file:Suppress("unused")

package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class PicInfo {
    var type : Int? = null
    var number : Int? = null
    var autoplay : Boolean? = null
    var loop : Boolean? = null
    var pic : String? = null
    var contentDescription : String? = null
    var effectSrc : String? = null
    var effectColor : String? = null
}

internal interface IPicInfoCreator {
    var picInfo : PicInfo?

    fun picInfo(consumer : Consumer<PicInfo>) = picInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun picInfo(block : PicInfo.() -> Unit) {
        val info = picInfo ?: PicInfo().also { picInfo = it }
        info.apply(block)
    }
}
