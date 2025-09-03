@file:Suppress("unused")

package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class ProgressInfo {
    var progress : Int? = null
    var isCCW : Boolean? = null
    var colorReach : String? = null
    var colorUnReach : String? = null
}

internal interface IProgressInfoCreator {
    var progressInfo : ProgressInfo?

    fun progressInfo(consumer : Consumer<ProgressInfo>) = progressInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun progressInfo(block : ProgressInfo.() -> Unit) {
        val info = progressInfo ?: ProgressInfo().also { progressInfo = it }
        info.apply(block)
    }
}
