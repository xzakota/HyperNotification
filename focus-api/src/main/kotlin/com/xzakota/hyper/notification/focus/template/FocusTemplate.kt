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
    /**
     * 文本组件
     */
    var baseInfo : BaseInfo? = null

    /**
     * 图文组件
     */
    var chatInfo : ChatInfo? = null

    /**
     * 强调图⽂组件
     */
    var highlightInfo : HighlightInfo? = null

    /**
     * 按钮组件
     */
    var hintInfo : HintInfo? = null

    /**
     * 进度组件
     */
    var progressInfo : ProgressInfo? = null

    /**
     * 识别图形组件
     */
    var picInfo : PicInfo? = null

    /**
     * 模板背景
     */
    var bgInfo : BgInfo? = null

    /**
     * 按钮组件
     */
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
