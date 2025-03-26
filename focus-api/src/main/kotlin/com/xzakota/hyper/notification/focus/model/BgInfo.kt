package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Serializable
data class BgInfo(
    var type : Int? = null,
    var colorBg : String? = null,
    var picBg : String? = null
)
