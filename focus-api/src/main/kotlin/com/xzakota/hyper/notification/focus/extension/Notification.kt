@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.extension

import android.app.Notification
import com.xzakota.hyper.notification.focus.FocusNotification
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplate
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplateV3
import com.xzakota.hyper.notification.focus.template.FocusTemplate

@JvmSynthetic
fun FocusNotification.buildIn(n : Notification) {
    n.extras.putAll(buildBundle())
}

@JvmSynthetic
fun Notification.addFocusParamV2(
    block : FocusTemplate.() -> Unit
) : Notification = apply {
    extras.putAll(FocusNotification.buildV2(block))
}

@JvmSynthetic
fun Notification.addCustomFocusParamV2(
    block : CustomFocusTemplate.() -> Unit
) : Notification = apply {
    extras.putAll(FocusNotification.buildCustomV2(block))
}

@JvmSynthetic
fun Notification.addFocusParamV3(
    block : FocusTemplate.() -> Unit
) : Notification = apply {
    extras.putAll(FocusNotification.buildV2(block))
}

@JvmSynthetic
fun Notification.addCustomFocusParamV3(
    block : CustomFocusTemplateV3.() -> Unit
) : Notification = apply {
    extras.putAll(FocusNotification.buildCustomV3(block))
}
