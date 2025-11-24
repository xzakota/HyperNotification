package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Suppress("unused")
@Serializable
class ProgressInfo {
    /**
     * 当前进度
     */
    var progress : Int? = null

    /**
     * 进度条起始颜⾊
     */
    var colorProgress : String? = null

    /**
     * 进度条结束颜⾊
     */
    var colorProgressEnd : String? = null

    /**
     * 前进图形
     */
    var picForward : String? = null

    /**
     * 中间节点图标(进度通过)
     * - 位置: 相对进度条居中
     */
    var picMiddle : String? = null

    /**
     * 中间节点图标(进度未通过)
     * - 位置: 相对进度条居中
     */
    var picMiddleUnselected : String? = null

    /**
     * ⽬标点图标(进度通过)
     * - 位置: 与进度条右对⻬
     */
    var picEnd : String? = null

    /**
     * ⽬标点图标(进度未通过)
     * - 位置: 与进度条右对⻬
     */
    var picEndUnselected : String? = null
}

@Suppress("unused")
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
