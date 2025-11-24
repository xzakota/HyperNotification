@file:Suppress("unused")

package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class PicInfo {
    /**
     * 图⽚类型
     * - `0` (默认值) 静态图⽚
     */
    var type : Int? = null

    var contentDescription : String? = null
    var number : Int? = null
    var pic : String? = null
    var effectSrc : String? = null
    var effectColor : String? = null
    var autoplay : Boolean? = null
    var loop : Boolean? = null
}

internal interface IPicInfoCreator {
    /**
     * 图标属性参数
     */
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
