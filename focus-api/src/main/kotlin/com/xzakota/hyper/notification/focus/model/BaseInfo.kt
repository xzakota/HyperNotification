package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class BaseInfo : TextAndColorInfo() {
    var type : Int? = null
    var showDivider : Boolean? = null
    var showContentDivider : Boolean? = null
    var setMarginTop : Boolean? = null
    var setMarginBottom : Boolean? = null
    var picFunction : String? = null
}
