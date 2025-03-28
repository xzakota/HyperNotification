@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
data class ActionInfo(
    var action : String? = null,
    var actionIcon : String? = null,
    var actionIconDark : String? = null,
    var actionIntent : String? = null,
    var actionIntentType : Int? = null,
    var actionTitle : String? = null,
    var actionTitleColor : String? = null,
    var actionTitleColorDark : String? = null,
    var actionBgColor : String? = null,
    var actionBgColorDark : String? = null
)

internal interface IActionInfoCreator {
    var actionInfo : ActionInfo?

    fun actionInfo(consumer : Consumer<ActionInfo>) = actionInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun actionInfo(block : ActionInfo.() -> Unit) {
        val info = actionInfo ?: ActionInfo().also { actionInfo = it }
        info.apply(block)
    }
}
