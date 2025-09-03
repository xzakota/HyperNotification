@file:Suppress("unused")

package com.xzakota.hyper.notification.common.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class TimerInfo {
    var timerType : Int? = null
    var timerTotal : Long? = null
    var timerWhen : Long? = null
    var timerSystemCurrent : Long? = null
}

internal interface ITimerInfoCreator {
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
