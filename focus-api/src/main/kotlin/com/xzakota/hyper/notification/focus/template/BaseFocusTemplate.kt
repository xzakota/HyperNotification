@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.template

import android.os.Parcelable
import com.xzakota.hyper.notification.focus.FocusNotification
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
open class BaseFocusTemplate internal constructor() {
    var ticker : String? = null
    var tickerPic : String? = null
    var tickerPicDark : String? = null
    var timeout : Int? = null
    var updatable : Boolean? = null
    var showSmallIcon : Boolean? = null
    var enableFloat : Boolean? = null
    var aodPic : String? = null
    var aodTitle : String? = null
    var reopen : String? = null

    @Transient
    internal var notification : FocusNotification? = null

    internal fun configWith(notification : FocusNotification) {
        this.notification = notification
    }

    fun createPicture(key : String, value : Parcelable?) : String? = notification?.createPicture(key, value)
    fun createAction(key : String, value : Parcelable?) : String? = notification?.createAction(key, value)
}

internal interface IExtraV3Param {
    var sequence : Long?
    var cancel : Boolean?
    var hideDeco : Boolean?
    var isShowNotification : Boolean?
    var islandFirstFloat : Boolean?
    var notifyId : String?
    var orderId : String?
    var outEffectColor : String?
    var outEffectSrc : String?
    var business : String?
}
