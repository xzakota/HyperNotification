package com.xzakota.hyper.notification.focus.model

import com.xzakota.hyper.notification.focus.dsl.FocusNotificationDsl
import kotlinx.serialization.Serializable

@FocusNotificationDsl
@Serializable
class IconTextInfo : TextAndColorInfo(), IAnimIconInfoCreator {
    var type : Int? = null

    override var animIconInfo : AnimIconInfo? = null
}
