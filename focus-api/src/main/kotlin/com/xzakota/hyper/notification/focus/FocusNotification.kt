package com.xzakota.hyper.notification.focus

import android.os.Bundle
import android.os.Parcelable
import com.xzakota.hyper.notification.focus.model.FocusTemplate
import com.xzakota.hyper.notification.focus.util.JSONUtils
import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Suppress("unused", "MemberVisibilityCanBePrivate")
class FocusNotification private constructor() {
    private lateinit var template : FocusParam
    private val pics = mutableMapOf<String, Parcelable?>()
    private val actions = mutableMapOf<String, Parcelable?>()
    // internal var isCustomFocus = false

    fun buildBundle() : Bundle = Bundle().apply {
        putString("miui.focus.param", getParamJSON())

        if (pics.isNotEmpty()) {
            putBundle("miui.focus.pics", buildPicsBundle())
        }

        if (pics.isNotEmpty()) {
            putBundle("miui.focus.actions", buildActionsBundle())
        }
    }

    fun getParamJSON() : String = JSONUtils.toJSONString(template)

    internal fun createPicture(key : String, value : Parcelable?) : String? = if (value != null) {
        pics[key] = value
        key
    } else {
        null
    }

    internal fun createAction(key : String, value : Parcelable?) : String? = if (value != null) {
        actions[key] = value
        key
    } else {
        null
    }

    private fun buildPicsBundle() : Bundle = Bundle().apply {
        pics.forEach { (k, v) ->
            putParcelable(k, v)
        }
    }

    private fun buildActionsBundle() : Bundle = Bundle().apply {
        actions.forEach { (k, v) ->
            putParcelable(k, v)
        }
    }

    private fun paramV2(consumer : Consumer<FocusTemplate>) = paramV2 {
        consumer.accept(this)
    }

    @JvmSynthetic
    private inline fun paramV2(crossinline block : FocusTemplate.() -> Unit) {
        template = FocusParam.V2(
            FocusTemplate().apply {
                configWith(this@FocusNotification)
                block()
            }
        )
    }

    override fun toString() : String = "param => ${getParamJSON()}, pics(${pics.size}) => ${pics.keys}"

    companion object {
        @JvmStatic
        fun createV2(consumer : Consumer<FocusTemplate>) : FocusNotification = FocusNotification().apply {
            paramV2(consumer)
        }

        @JvmStatic
        @JvmSynthetic
        fun createV2(block : FocusTemplate.() -> Unit) : FocusNotification = FocusNotification().apply {
            paramV2(block)
        }

        @JvmStatic
        fun buildV2(consumer : Consumer<FocusTemplate>) : Bundle = createV2(consumer).buildBundle()

        @JvmStatic
        @JvmSynthetic
        fun buildV2(block : FocusTemplate.() -> Unit) : Bundle = createV2(block).buildBundle()
    }

    @Serializable
    internal sealed class FocusParam {
        @Suppress("PropertyName")
        @Serializable
        class V2(val param_v2 : FocusTemplate) : FocusParam()
    }
}
