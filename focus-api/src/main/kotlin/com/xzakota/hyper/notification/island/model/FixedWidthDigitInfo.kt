package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class FixedWidthDigitInfo {
    var content : String? = null
    var digit : String? = null
    var turnAnim : Boolean? = null
    var showHighlightColor : Boolean? = null
}
