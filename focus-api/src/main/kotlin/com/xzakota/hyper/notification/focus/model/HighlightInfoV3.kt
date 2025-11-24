package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class HighlightInfoV3 : TextAndColorInfo(), IActionInfoCreator {
    /**
     * ⽂字标签
     */
    var highLightText : String? = null
    var highLightTextColor : String? = null
    var highLightTextColorDark : String? = null
    var highLightbgColor : String? = null
    var highLightbgColorDark : String? = null

    /**
     * ⾼亮⽂本
     */
    var primaryColor : String? = null
    var primaryColorDark : String? = null
    var primaryText : String? = null

    /**
     * 补充⽂本
     */
    var secondaryColor : String? = null
    var secondaryColorDark : String? = null
    var secondaryText : String? = null

    /**
     * 补充⽂本是否划线
     */
    var showSecondaryLine : Boolean? = null

    override var actionInfo : ActionInfo? = null
}
