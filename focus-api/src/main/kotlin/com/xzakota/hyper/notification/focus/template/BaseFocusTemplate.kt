@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.template

import android.os.Parcelable
import com.xzakota.hyper.notification.focus.FocusNotification
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.lang.reflect.Modifier

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
    internal lateinit var notification : FocusNotification

    internal fun configWith(notification : FocusNotification) {
        this.notification = notification
    }

    fun createPicture(key : String, value : Parcelable) : String = notification.createPicture(key, value)
    fun createAction(key : String, value : Parcelable) : String = notification.createAction(key, value)

    open fun copyFrom(from: Any) {
        reflectCollect(from, BaseFocusTemplate::class.java)
    }

    protected fun reflectCollect(from: Any, clazz : Class<*>) {
        if (javaClass != clazz && !javaClass.isInstance(from)) {
            return
        }

        clazz.declaredFields.forEach {
            if (Modifier.isStatic(it.modifiers)) {
                return@forEach
            }

            it.isAccessible = true
            val obj = it.get(from)
            if (obj != null) {
                it.set(this, obj)
            }
        }
    }
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
