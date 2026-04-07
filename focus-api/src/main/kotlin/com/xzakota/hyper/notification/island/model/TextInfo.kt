@file:Suppress("unused")

package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class TextInfo {
    /**
     * 大字
     */
    var title : String? = null

    /**
     * 前置小字
     */
    var frontTitle : String? = null

    /**
     * 后置小字
     */
    var content : String? = null

    /**
     * 是否使用强调色
     */
    var showHighlightColor : Boolean? = null

    /**
     * 是否使用窄字体
     */
    var narrowFont : Boolean? = null

    var isTitleDigit : Boolean? = null

    var turnAnim : Boolean? = null
}

internal interface ITextInfoCreator {
    /**
     * 文本属性参数
     */
    var textInfo : TextInfo?

    fun textInfo(consumer : Consumer<TextInfo>) = textInfo(consumer::accept)

    @JvmSynthetic
    fun textInfo(block : TextInfo.() -> Unit) {
        val info = textInfo ?: TextInfo().also { textInfo = it }
        info.apply(block)
    }
}

