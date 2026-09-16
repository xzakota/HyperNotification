@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.extension

import android.app.Notification
import com.xzakota.hyper.notification.focus.FocusNotification
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplate
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplateV3
import com.xzakota.hyper.notification.focus.template.FocusTemplate
import com.xzakota.hyper.notification.focus.template.FocusTemplateV3

fun FocusNotification.buildIn(n : Notification) {
    n.extras.putAll(buildBundle())
}

inline fun Notification.addFocusParamV2(
    crossinline block : FocusTemplate.() -> Unit
) : Notification = apply {
    extras.putAll(FocusNotification.buildV2(block))
}

inline fun Notification.addCustomFocusParamV2(
    crossinline block : CustomFocusTemplate.() -> Unit
) : Notification = apply {
    extras.putAll(FocusNotification.buildCustomV2(block))
}

inline fun Notification.addFocusParamV3(
    crossinline block : FocusTemplateV3.() -> Unit
) : Notification = apply {
    extras.putAll(FocusNotification.buildV3(block))
}

inline fun Notification.addCustomFocusParamV3(
    crossinline block : CustomFocusTemplateV3.() -> Unit
) : Notification = apply {
    extras.putAll(FocusNotification.buildCustomV3(block))
}
