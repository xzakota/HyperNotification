package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class IconTextInfo : TextAndColorInfo(), IAnimIconInfoCreator {
    var type : Int? = null
    override var animIconInfo : AnimIconInfo? = null
}
