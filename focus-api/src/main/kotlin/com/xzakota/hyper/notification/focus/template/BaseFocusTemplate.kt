@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.template

import android.os.Parcelable
import com.xzakota.hyper.notification.focus.FocusNotification
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.lang.reflect.Modifier

@Serializable
open class BaseFocusTemplate internal constructor() {
    /**
     * OS2 焦点通知状态栏显示文案
     */
    var ticker : String? = null

    /**
     * OS2 焦点通知浅色状态栏图标, 不传默认为应用图标
     */
    var tickerPic : String? = null

    /**
     * OS2 焦点通知深色状态栏图标
     */
    var tickerPicDark : String? = null

    /**
     * 是否显示小图标
     */
    var showSmallIcon : Boolean? = null

    /**
     * 通知的默认消失时间
     * - 单位: min
     * - 默认值: 720
     */
    var timeout : Int? = null

    /**
     * 是否为持续性通知
     * - 默认值: false
     */
    var updatable : Boolean? = null

    /**
     * 是否允许悬浮通知
     * - 默认值: false
     */
    var enableFloat : Boolean? = null

    /**
     * 息屏模式图标, 不传默认为应用图标
     */
    var aodPic : String? = null

    /**
     * 息屏焦点通知显示文案
     */
    var aodTitle : String? = null

    /**
     * 当 updatable == true 时, 相同 notification id 的通知被 cancel 后, 再次发送是否显示
     * - `reopen` 再次显示
     * - `close` (默认值) 不显示
     */
    var reopen : String? = null

    /**
     * 应用焦点通知权限被关闭时退化为普通通知的处理方式
     * - `false`: (默认值) 通知正常显示不被过滤
     * - `true`: 通知后被过滤, 不显示
     */
    var filterWhenNoPermission: Boolean? = null

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
    /**
     * 是否直接结束通知
     * 针对 mipush, 值为 true 时, 触发移除通知
     */
    var cancel : Boolean?

    /**
     * 针对折叠屏设备, 是否创建用于 deco 显示的通知样式
     */
    var hideDeco : Boolean?

    /**
     * 是否在通知中心显示通知
     * - 默认值: true
     */
    var isShowNotification : Boolean?

    /**
     * 通知第一次出现时, 是否自动显示展开态
     * - `true` (默认值) 展开态
     * - `false` 摘要态
     */
    var islandFirstFloat : Boolean?

    /**
     * 此属性目前无任何作用
     */
    var outEffectColor : String?

    /**
     * 通知悬浮显示时的特效
     * - 目前仅有一个发光环绕效果, 将此属性设为非空文本即可
     */
    var outEffectSrc : String?

    /**
     * 本订单第几次更新通知, 避免通知展示乱序
     */
    var sequence : Long?

    /**
     * 运营场景
     */
    var business : String?

    /**
     * 通知标识符
     */
    var notifyId : String?

    /**
     * 订单号
     */
    var orderId : String?
}
