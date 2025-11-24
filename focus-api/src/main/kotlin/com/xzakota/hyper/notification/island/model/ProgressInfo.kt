@file:Suppress("unused")

package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class ProgressInfo {
    /**
     * 当前进度
     */
    var progress : Int? = null

    /**
     * 进度条的起始位置
     * - `false` (默认值, 3 点钟⽅向) 0 度为起始位置
     * - `true` (12 点钟⽅向) 270 度为起始位置
     */
    var isCCW : Boolean? = null

    /**
     * 当前进度的颜⾊
     */
    var colorReach : String? = null

    /**
     * 当前未到进度的颜⾊
     */
    var colorUnReach : String? = null
}

internal interface IProgressInfoCreator {
    /**
     * 进度属性参数
     */
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
