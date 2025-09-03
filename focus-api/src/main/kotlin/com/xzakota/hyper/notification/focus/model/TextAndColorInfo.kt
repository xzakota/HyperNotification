package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
abstract class TextAndColorInfo {
    var title : String? = null
    var colorTitle : String? = null
    var colorTitleDark : String? = null

    var subTitle : String? = null
    var colorSubTitle : String? = null
    var colorSubTitleDark : String? = null

    var extraTitle : String? = null
    var colorExtraTitle : String? = null
    var colorExtraTitleDark : String? = null

    var specialTitle : String? = null
    var colorSpecialTitle : String? = null
    var colorSpecialTitleDark : String? = null
    var colorSpecialBg : String? = null

    var content : String? = null
    var colorContent : String? = null
    var colorContentDark : String? = null

    var subContent : String? = null
    var colorSubContent : String? = null
    var colorSubContentDark : String? = null
}
