@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.model

import android.os.Parcelable
import android.widget.RemoteViews
import com.xzakota.hyper.notification.focus.FocusNotification
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.util.function.Consumer

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

@Serializable
data class FocusTemplate(
    var baseInfo : BaseInfo? = null,
    var chatInfo : ChatInfo? = null,
    var highlightInfo : HighlightInfo? = null,
    var hintInfo : HintInfo? = null,
    var progressInfo : ProgressInfo? = null,
    var picInfo : PicInfo? = null,
    var bgInfo : BgInfo? = null,
    var actions : ArrayList<ActionInfo>? = null
) : BaseFocusTemplate() {
    fun baseInfo(consumer : Consumer<BaseInfo>) = baseInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun baseInfo(block : BaseInfo.() -> Unit) {
        val info = baseInfo ?: BaseInfo().also { baseInfo = it }
        info.apply(block)
    }

    fun chatInfo(consumer : Consumer<ChatInfo>) = chatInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun chatInfo(block : ChatInfo.() -> Unit) {
        val info = chatInfo ?: ChatInfo().also { chatInfo = it }
        info.apply(block)
    }

    fun highlightInfo(consumer : Consumer<HighlightInfo>) = highlightInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun highlightInfo(block : HighlightInfo.() -> Unit) {
        val info = highlightInfo ?: HighlightInfo().also { highlightInfo = it }
        info.apply(block)
    }

    fun hintInfo(consumer : Consumer<HintInfo>) = hintInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun hintInfo(block : HintInfo.() -> Unit) {
        val info = hintInfo ?: HintInfo().also { hintInfo = it }
        info.apply(block)
    }

    fun progressInfo(consumer : Consumer<ProgressInfo>) = progressInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun progressInfo(block : ProgressInfo.() -> Unit) {
        val info = progressInfo ?: ProgressInfo().also { progressInfo = it }
        info.apply(block)
    }

    fun picInfo(consumer : Consumer<PicInfo>) = picInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun picInfo(block : PicInfo.() -> Unit) {
        val info = picInfo ?: PicInfo().also { picInfo = it }
        info.apply(block)
    }

    fun bgInfo(consumer : Consumer<BgInfo>) = bgInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun bgInfo(block : BgInfo.() -> Unit) {
        val info = bgInfo ?: BgInfo().also { bgInfo = it }
        info.apply(block)
    }

    fun actions(consumer : Consumer<ArrayList<ActionInfo>>) = actions {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun actions(block : ArrayList<ActionInfo>.() -> Unit) {
        val info = actions ?: arrayListOf<ActionInfo>().also { actions = it }
        info.apply(block)
    }

    fun ArrayList<ActionInfo>.addActionInfo(consumer : Consumer<ActionInfo>) = addActionInfo {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun ArrayList<ActionInfo>.addActionInfo(block : ActionInfo.() -> Unit) {
        add(ActionInfo().apply(block))
    }
}

@Serializable
class CustomFocusTemplate() : BaseFocusTemplate() {
    // var filterWhenNoPermission = false

    @Transient
    internal var rv = mutableMapOf<String, RemoteViews?>()

    fun createRemoteViews(key : String, value : RemoteViews?) {
        if (value != null) {
            rv[key] = value
        }
    }
    
    @Suppress("ClassName")
    companion object `Companion-Object` {
        const val LAYOUT = "miui.focus.rv"
        const val LAYOUT_NIGHT = "miui.focus.rvNight"
        const val LAYOUT_AOD = "miui.focus.rvAod"
        const val LAYOUT_FLIP_TINY = "miui.focus.rv.tiny"
        const val LAYOUT_FLIP_TINY_NIGHT = "miui.focus.rv.tinyNight"
        const val LAYOUT_DECO_LAND = "miui.focus.rv.deco.land"
        const val LAYOUT_DECO_LAND_NIGHT = "miui.focus.rv.deco.land.night"
        const val LAYOUT_DECO_PORT = "miui.focus.rv.deco.port"
        const val LAYOUT_DECO_PORT_NIGHT = "miui.focus.rv.deco.port.night"
    }
}
