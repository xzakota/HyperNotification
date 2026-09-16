package com.xzakota.hyper.notification.focus.extension

import android.os.Bundle

internal inline fun buildBundle(
    capacity : Int = 0,
    crossinline block : Bundle.() -> Unit
): Bundle = Bundle(capacity).apply(block)
