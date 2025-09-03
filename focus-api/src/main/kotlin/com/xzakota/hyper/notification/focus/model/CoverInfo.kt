package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class CoverInfo : TextAndColorInfo() {
    var picCover : String? = null
}
