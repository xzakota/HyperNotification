@file:Suppress("unused")

package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class TextInfo {
    var title : String? = null
    var frontTitle : String? = null
    var content : String? = null
    var isTitleDigit : Boolean? = null
    var turnAnim : Boolean? = null
    var showHighlightColor : Boolean? = null
    var narrowFont : Boolean? = null
}

internal interface ITextInfoCreator {
    var textInfo : TextInfo?

    fun textInfo(consumer : Consumer<TextInfo>) = textInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun textInfo(block : TextInfo.() -> Unit) {
        val info = textInfo ?: TextInfo().also { textInfo = it }
        info.apply(block)
    }
}

