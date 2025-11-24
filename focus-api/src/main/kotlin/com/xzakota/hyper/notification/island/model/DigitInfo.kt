package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
abstract class DigitInfo {
    /**
     * ⼩字
     */
    var content : String? = null

    /**
     * 定宽/等宽数字
     */
    var digit : String? = null

    /**
     * 是否使⽤强调⾊
     */
    var showHighlightColor : Boolean? = null

    var turnAnim : Boolean? = null
}
