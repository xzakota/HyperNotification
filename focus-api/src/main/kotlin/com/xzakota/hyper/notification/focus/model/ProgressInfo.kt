package com.xzakota.hyper.notification.focus.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class ProgressInfo {
    var progress : Int? = null
    var colorProgress : String? = null
    var colorProgressEnd : String? = null
    var picForward : String? = null
    var picMiddle : String? = null
    var picMiddleUnselected : String? = null
    var picEnd : String? = null
    var picEndUnselected : String? = null
}
