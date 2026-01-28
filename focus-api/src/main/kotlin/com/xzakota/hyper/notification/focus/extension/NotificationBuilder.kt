@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.extension

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import com.xzakota.hyper.notification.focus.FocusNotification
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplate
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplateV3
import com.xzakota.hyper.notification.focus.template.FocusTemplate
import com.xzakota.hyper.notification.focus.template.FocusTemplateV3

@JvmSynthetic
fun FocusNotification.buildIn(builder : Notification.Builder) {
    builder.addExtras(buildBundle())
}

@JvmSynthetic
fun FocusNotification.createBuilder(
    context : Context,
    channelId : String,
    block : Notification.Builder.() -> Unit
) : Notification.Builder = Notification.Builder(context, channelId).also {
    buildIn(it)
    block(it)
}

@JvmSynthetic
fun Notification.Builder.notify(manager : NotificationManager, id : Int) {
    manager.notify(id, build())
}

@JvmSynthetic
fun Notification.Builder.addFocusParamV2(
    block : FocusTemplate.() -> Unit
) : Notification.Builder = apply {
    addExtras(FocusNotification.buildV2(block))
}

@JvmSynthetic
fun Notification.Builder.addCustomFocusParamV2(
    block : CustomFocusTemplate.() -> Unit
) : Notification.Builder = apply {
    addExtras(FocusNotification.buildCustomV2(block))
}

@JvmSynthetic
fun Notification.Builder.addFocusParamV3(
    block : FocusTemplateV3.() -> Unit
) : Notification.Builder = apply {
    addExtras(FocusNotification.buildV3(block))
}

@JvmSynthetic
fun Notification.Builder.addCustomFocusParamV3(
    block : CustomFocusTemplateV3.() -> Unit
) : Notification.Builder = apply {
    addExtras(FocusNotification.buildCustomV3(block))
}
