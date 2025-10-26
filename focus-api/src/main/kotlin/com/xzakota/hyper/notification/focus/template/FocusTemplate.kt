@file:Suppress("unused")

package com.xzakota.hyper.notification.focus.template

import com.xzakota.hyper.notification.focus.model.ActionInfo
import com.xzakota.hyper.notification.focus.model.BaseInfo
import com.xzakota.hyper.notification.focus.model.BgInfo
import com.xzakota.hyper.notification.focus.model.ChatInfo
import com.xzakota.hyper.notification.focus.model.HighlightInfo
import com.xzakota.hyper.notification.focus.model.HintInfo
import com.xzakota.hyper.notification.focus.model.PicInfo
import com.xzakota.hyper.notification.focus.model.ProgressInfo
import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
open class FocusTemplate : BaseFocusTemplate() {
    var baseInfo : BaseInfo? = null
    var chatInfo : ChatInfo? = null
    var highlightInfo : HighlightInfo? = null
    var hintInfo : HintInfo? = null
    var progressInfo : ProgressInfo? = null
    var picInfo : PicInfo? = null
    var bgInfo : BgInfo? = null
    var actions : ArrayList<ActionInfo>? = null

    override fun copyFrom(from : Any) {
        super.copyFrom(from)
        reflectCollect(from, FocusTemplate::class.java)
    }

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
