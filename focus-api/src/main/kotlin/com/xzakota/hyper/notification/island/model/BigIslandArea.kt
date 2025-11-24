package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Suppress("unused")
@Serializable
class BigIslandArea {
    var textInfo : TextInfo? = null
    var picInfo : PicInfo? = null

    /**
     * 左图⽂组件
     */
    var imageTextInfoLeft : ImageTextInfo? = null

    /**
     * 右图⽂组件
     */
    var imageTextInfoRight : ImageTextInfo? = null

    /**
     * 进度⽂本组件
     */
    var progressTextInfo : ProgressTextInfo? = null

    /**
     * 定宽数字⽂本组件
     */
    var fixedWidthDigitInfo : FixedWidthDigitInfo? = null

    /**
     * 等宽数字⽂本组件
     */
    var sameWidthDigitInfo : SameWidthDigitInfo? = null

    fun imageTextInfoLeft(consumer : Consumer<ImageTextInfo>) = imageTextInfoLeft {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun imageTextInfoLeft(block : ImageTextInfo.() -> Unit) {
        val info = imageTextInfoLeft ?: ImageTextInfo().also { imageTextInfoLeft = it }
        info.apply(block)
    }

    fun imageTextInfoRight(consumer : Consumer<ImageTextInfo>) = imageTextInfoRight {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun imageTextInfoRight(block : ImageTextInfo.() -> Unit) {
        val info = imageTextInfoRight ?: ImageTextInfo().also { imageTextInfoRight = it }
        info.apply(block)
    }

    fun progressTextInfo(consumer : Consumer<ProgressTextInfo>) = progressTextInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun progressTextInfo(block : ProgressTextInfo.() -> Unit) {
        val info = progressTextInfo ?: ProgressTextInfo().also { progressTextInfo = it }
        info.apply(block)
    }

    fun fixedWidthDigitInfo(consumer : Consumer<FixedWidthDigitInfo>) = fixedWidthDigitInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun fixedWidthDigitInfo(block : FixedWidthDigitInfo.() -> Unit) {
        val info = fixedWidthDigitInfo ?: FixedWidthDigitInfo().also { fixedWidthDigitInfo = it }
        info.apply(block)
    }

    fun sameWidthDigitInfo(consumer : Consumer<SameWidthDigitInfo>) = sameWidthDigitInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun sameWidthDigitInfo(block : SameWidthDigitInfo.() -> Unit) {
        val info = sameWidthDigitInfo ?: SameWidthDigitInfo().also { sameWidthDigitInfo = it }
        info.apply(block)
    }
}
