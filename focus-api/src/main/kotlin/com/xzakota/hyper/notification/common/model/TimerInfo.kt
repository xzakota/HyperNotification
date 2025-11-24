@file:Suppress("unused")

package com.xzakota.hyper.notification.common.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class TimerInfo {
    /**
     * 计时类型, 若设置 0, 则需设置相同位置上的标题
     * - `-2` 倒计时暂停
     * - `-1` 倒计时开始
     * - `0` 默认值
     * - `1` 正计时开始
     * - `2` 正计时暂停
     */
    var timerType : Int? = null

    /**
     * 计时起点(毫秒的时间戳)
     */
    var timerWhen : Long? = null

    /**
     * 计时进度
     */
    var timerTotal : Long? = null

    /**
     * 计时误差(毫秒的时间戳)
     */
    var timerSystemCurrent : Long? = null
}

internal interface ITimerInfoCreator {
    /**
     * 计时器属性参数
     */
    var timerInfo : TimerInfo?

    fun timerInfo(consumer : Consumer<TimerInfo>) = timerInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun timerInfo(block : TimerInfo.() -> Unit) {
        val info = timerInfo ?: TimerInfo().also { timerInfo = it }
        info.apply(block)
    }
}
