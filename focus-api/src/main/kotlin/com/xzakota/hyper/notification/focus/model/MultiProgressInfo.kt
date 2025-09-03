package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class MultiProgressInfo : TextAndColorInfo() {
    var progress : Int? = null
    var points : Int? = null
    var color : String? = null
}
