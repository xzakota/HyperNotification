package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
abstract class TextAndColorInfo {
    /**
     * 描述当前状况的关键信息(主要文本 1)
     */
    var title : String? = null
    var colorTitle : String? = null
    var colorTitleDark : String? = null

    /**
     * 描述当前状况的关键信息(主要文本 2)
     */
    var subTitle : String? = null
    var colorSubTitle : String? = null
    var colorSubTitleDark : String? = null

    /**
     * 补充说明
     */
    var extraTitle : String? = null
    var colorExtraTitle : String? = null
    var colorExtraTitleDark : String? = null

    /**
     * 需要强调的特殊⽂字标签
     */
    var specialTitle : String? = null
    var colorSpecialTitle : String? = null
    var colorSpecialTitleDark : String? = null
    var colorSpecialBg : String? = null

    /**
     * 当前状况的前置描述(次要⽂本 1)
     */
    var content : String? = null
    var colorContent : String? = null
    var colorContentDark : String? = null

    /**
     * 当前状况的前置描述(次要⽂本 2)
     */
    var subContent : String? = null
    var colorSubContent : String? = null
    var colorSubContentDark : String? = null
}
