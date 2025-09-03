@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class AnimIconInfo : TextAndColorInfo() {
    var type : Int? = null
    var number : Int? = null
    var src : String? = null
    var srcDark : String? = null
    var effectSrc : String? = null
    var effectColor : String? = null
    var autoplay : Boolean? = null
    var loop : Boolean? = null
}

internal interface IAnimIconInfoCreator {
    var animIconInfo : AnimIconInfo?

    fun animIconInfo(consumer : Consumer<AnimIconInfo>) = animIconInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun animIconInfo(block : AnimIconInfo.() -> Unit) {
        val info = animIconInfo ?: AnimIconInfo().also { animIconInfo = it }
        info.apply(block)
    }
}
