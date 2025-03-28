@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

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

@Serializable
data class BaseInfo(
    var type : Int? = null,
    var showDivider : Boolean? = null,
    var showContentDivider : Boolean? = null,
    var setMarginTop : Boolean? = null,
    var setMarginBottom : Boolean? = null,
    var picFunction : String? = null
) : TextAndColorInfo()

@Serializable
data class HintInfo(
    var type : Int? = null,
    var titleLineCount : Int? = null,
    var colorContentBg : String? = null,
    var picContent : String? = null,
    override var timerInfo : TimerInfo? = null,
    override var actionInfo : ActionInfo? = null
) : TextAndColorInfo(), ITimerInfoCreator, IActionInfoCreator

@Serializable
data class HighlightInfo(
    var type : Int? = null,
    var picFunction : String? = null,
    var picFunctionDark : String? = null,
    override var timerInfo : TimerInfo? = null
) : TextAndColorInfo(), ITimerInfoCreator

@Serializable
data class ChatInfo(
    var picProfile : String? = null,
    override var timerInfo : TimerInfo? = null
) : TextAndColorInfo(), ITimerInfoCreator
