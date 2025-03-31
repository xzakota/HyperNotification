package com.xzakota.hyper.notification.focus

import android.os.Bundle
import android.os.Parcelable
import com.xzakota.hyper.notification.focus.model.CustomFocusTemplate
import com.xzakota.hyper.notification.focus.model.FocusTemplate
import com.xzakota.hyper.notification.focus.util.JSONUtils
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Suppress("unused", "MemberVisibilityCanBePrivate")
class FocusNotification private constructor() {
    private lateinit var template : FocusParam
    private var focusVersion = -1
    private var isCustomFocus = false
    private val pics = mutableMapOf<String, Parcelable?>()
    private val actions = mutableMapOf<String, Parcelable?>()

    fun buildBundle() : Bundle = Bundle().apply {
        if (isCustomFocus) {
            val param = (template as FocusParam.CustomV2).param
            putString("miui.focus.param.custom", JSONUtils.toJSONString(param))
            param.rv.forEach { (k, v) ->
                putParcelable(k, v)
            }
        } else {
            putString("miui.focus.param", getParamJSON())
        }

        if (pics.isNotEmpty()) {
            putBundle("miui.focus.pics", buildPicsBundle())
        }

        if (actions.isNotEmpty()) {
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

    private inline fun paramV2(crossinline block : FocusTemplate.() -> Unit) {
        focusVersion = 2
        isCustomFocus = false
        template = FocusParam.V2(
            FocusTemplate().apply {
                configWith(this@FocusNotification)
                block()
            }
        )
    }

    private inline fun customParamV2(crossinline block : CustomFocusTemplate.() -> Unit) {
        focusVersion = 2
        isCustomFocus = true
        template = FocusParam.CustomV2(
            CustomFocusTemplate().apply {
                configWith(this@FocusNotification)
                block()
            }
        )
    }

    override fun toString() : String = "param => ${getParamJSON()}, pics(${pics.size}) => ${pics.keys}"

    @Suppress("ClassName")
    companion object `Companion-Object` {
        /* ====================================================
         * for default focus style
         * ==================================================== */

        @JvmStatic
        fun createV2(consumer : Consumer<FocusTemplate>) : FocusNotification = FocusNotification().apply {
            paramV2(consumer)
        }

        @JvmSynthetic
        fun createV2(block : FocusTemplate.() -> Unit) : FocusNotification = FocusNotification().apply {
            paramV2(block)
        }

        @JvmStatic
        fun buildV2(consumer : Consumer<FocusTemplate>) : Bundle = createV2(consumer).buildBundle()

        @JvmSynthetic
        fun buildV2(block : FocusTemplate.() -> Unit) : Bundle = createV2(block).buildBundle()

        /* ====================================================
         * for custom focus style
         * ==================================================== */

        @JvmStatic
        fun createCustomV2(consumer : Consumer<CustomFocusTemplate>) : FocusNotification = FocusNotification().apply {
            createCustomV2(consumer)
        }

        @JvmSynthetic
        fun createCustomV2(block : CustomFocusTemplate.() -> Unit) : FocusNotification = FocusNotification().apply {
            customParamV2(block)
        }

        @JvmStatic
        fun buildCustomV2(consumer : Consumer<CustomFocusTemplate>) : Bundle = createCustomV2(consumer).buildBundle()

        @JvmSynthetic
        fun buildCustomV2(block : CustomFocusTemplate.() -> Unit) : Bundle = createCustomV2(block).buildBundle()
    }

    @Serializable
    internal sealed class FocusParam {
        @Serializable
        class V2(@SerialName("param_v2") val param : FocusTemplate) : FocusParam()

        @Serializable
        class CustomV2(val param : CustomFocusTemplate) : FocusParam()
    }
}
