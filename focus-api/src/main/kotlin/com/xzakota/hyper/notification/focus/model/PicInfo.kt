package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class PicInfo : IActionInfoCreator {
    var type : Int = 0
    var pic : String? = null
    override var actionInfo : ActionInfo? = null
}
