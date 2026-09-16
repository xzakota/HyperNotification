package com.xzakota.hyper.notification.island.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@Suppress("unused")
@FocusNotificationDsl
@Serializable
class BigIslandArea {
    var textInfo : TextInfo? = null
    var picInfo : PicInfo? = null

    /**
     * 左图文组件
     */
    var imageTextInfoLeft : ImageTextInfo? = null

    /**
     * 右图文组件
     */
    var imageTextInfoRight : ImageTextInfo? = null

    /**
     * 进度文本组件
     */
    var progressTextInfo : ProgressTextInfo? = null

    /**
     * 定宽数字文本组件
     */
    var fixedWidthDigitInfo : FixedWidthDigitInfo? = null

    /**
     * 等宽数字文本组件
     */
    var sameWidthDigitInfo : SameWidthDigitInfo? = null

    fun imageTextInfoLeft(block : ImageTextInfo.() -> Unit) {
        val info = imageTextInfoLeft ?: ImageTextInfo().also { imageTextInfoLeft = it }
        info.apply(block)
    }

    fun imageTextInfoRight(block : ImageTextInfo.() -> Unit) {
        val info = imageTextInfoRight ?: ImageTextInfo().also { imageTextInfoRight = it }
        info.apply(block)
    }

    fun progressTextInfo(block : ProgressTextInfo.() -> Unit) {
        val info = progressTextInfo ?: ProgressTextInfo().also { progressTextInfo = it }
        info.apply(block)
    }

    fun fixedWidthDigitInfo(block : FixedWidthDigitInfo.() -> Unit) {
        val info = fixedWidthDigitInfo ?: FixedWidthDigitInfo().also { fixedWidthDigitInfo = it }
        info.apply(block)
    }

    fun sameWidthDigitInfo(block : SameWidthDigitInfo.() -> Unit) {
        val info = sameWidthDigitInfo ?: SameWidthDigitInfo().also { sameWidthDigitInfo = it }
        info.apply(block)
    }
}
