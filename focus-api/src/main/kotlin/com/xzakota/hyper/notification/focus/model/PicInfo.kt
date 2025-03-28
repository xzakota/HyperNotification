package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
data class PicInfo(
    var type : Int = 0,
    var pic : String? = null,
    override var actionInfo : ActionInfo? = null,
) : IActionInfoCreator
