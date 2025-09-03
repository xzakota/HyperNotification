package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class HighlightInfoV3 : TextAndColorInfo(), IActionInfoCreator {
    var showSecondaryLine : Boolean? = null
    var highLightText : String? = null
    var highLightTextColor : String? = null
    var highLightTextColorDark : String? = null
    var highLightbgColor : String? = null
    var highLightbgColorDark : String? = null
    var primaryColor : String? = null
    var primaryColorDark : String? = null
    var primaryText : String? = null
    var secondaryColor : String? = null
    var secondaryColorDark : String? = null
    var secondaryText : String? = null
    override var actionInfo : ActionInfo? = null
}
