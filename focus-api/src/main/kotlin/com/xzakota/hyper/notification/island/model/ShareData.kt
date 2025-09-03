package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class ShareData {
    var title : String? = null
    var content : String? = null
    var shareContent : String? = null
    var pic : String? = null
    var sharePic : String? = null
}
