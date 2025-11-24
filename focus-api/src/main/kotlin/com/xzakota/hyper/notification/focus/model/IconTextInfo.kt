package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Serializable
class IconTextInfo : TextAndColorInfo(), IAnimIconInfoCreator {
    var type : Int? = null

    override var animIconInfo : AnimIconInfo? = null
}
