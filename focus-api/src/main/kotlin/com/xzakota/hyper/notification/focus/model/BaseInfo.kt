package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class BaseInfo : TextAndColorInfo() {
    /**
     * ⽂本组件类型
     * - `1` 主要文本在前
     * - `2` 次要文本在前
     */
    var type : Int? = null

    /**
     * 是否显⽰次要⽂本间的分割符
     */
    var showDivider : Boolean? = null

    /**
     * 是否显⽰次要⽂本和功能图标的分割符
     */
    var showContentDivider : Boolean? = null

    /**
     * 功能图标
     */
    var picFunction : String? = null

    var setMarginTop : Boolean? = null
    var setMarginBottom : Boolean? = null
}
