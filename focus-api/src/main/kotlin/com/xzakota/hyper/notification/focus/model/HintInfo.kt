package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.common.model.ITimerInfoCreator
import com.xzakota.hyper.notification.common.model.TimerInfo
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class HintInfo : TextAndColorInfo(), ITimerInfoCreator, IActionInfoCreator {
    /**
     * 按钮组件类型
     * - `1` 显示次要文本
     * - `2` 隐藏次要文本
     */
    var type : Int? = null

    /**
     * 此属性目前无任何作用
     */
    var titleLineCount : Int? = null

    /**
     * 图⽂特殊标签背景⾊
     */
    var colorContentBg : String? = null

    /**
     * 图⽂特殊标签图标
     */
    var picContent : String? = null

    override var timerInfo : TimerInfo? = null
    override var actionInfo : ActionInfo? = null
}
