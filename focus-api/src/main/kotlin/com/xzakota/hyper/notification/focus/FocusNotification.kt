package com.xzakota.hyper.notification.focus

import android.os.Bundle
import android.os.Parcelable
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplate
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplateV3
import com.xzakota.hyper.notification.focus.template.FocusTemplate
import com.xzakota.hyper.notification.focus.template.FocusTemplateV3
import com.xzakota.hyper.notification.focus.util.JSONUtils
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Suppress("unused", "MemberVisibilityCanBePrivate")
class FocusNotification private constructor() {
    private lateinit var factory : FocusTemplateFactory
    private var focusVersion = -1
    private var isCustomFocus = false
    private val pics = mutableMapOf<String, Parcelable?>()
    private val actions = mutableMapOf<String, Parcelable?>()

    fun buildBundle() : Bundle = Bundle().apply {
        if (isCustomFocus) {
            val param = (factory as FocusTemplateFactory.CustomV2).param
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

    fun getParamJSON() : String = JSONUtils.toJSONString(factory)

    internal fun createPicture(key : String, value : Parcelable) : String = key.also {
        pics[it] = value
    }

    internal fun createAction(key : String, value : Parcelable) : String = key.also {
        actions[it] = value
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

    override fun toString() : String = "param => ${getParamJSON()}, pics(${pics.size}) => ${pics.keys}"

    @Suppress("ClassName")
    companion object `Companion-Object` {
        /* ====================================================
         * for default focus style
         * ==================================================== */

        @JvmStatic
        fun createV2(consumer : Consumer<FocusTemplate>) : FocusNotification = createV2 {
            consumer.accept(this)
        }

        @JvmSynthetic
        fun createV2(block : FocusTemplate.() -> Unit) : FocusNotification = FocusNotification().apply {
            focusVersion = 2
            isCustomFocus = false
            factory = FocusTemplateFactory.V2(
                FocusTemplate().also {
                    it.configWith(this)
                    it.block()
                }
            )
        }

        @JvmStatic
        fun createV3(consumer : Consumer<FocusTemplateV3>) : FocusNotification = createV3 {
            consumer.accept(this)
        }

        @JvmSynthetic
        fun createV3(block : FocusTemplateV3.() -> Unit) : FocusNotification = FocusNotification().apply {
            focusVersion = 3
            isCustomFocus = false
            factory = FocusTemplateFactory.V3(
                FocusTemplateV3().also {
                    it.configWith(this)
                    it.block()
                }
            )
        }

        @JvmStatic
        fun buildV2(consumer : Consumer<FocusTemplate>) : Bundle = createV2(consumer).buildBundle()

        @JvmSynthetic
        fun buildV2(block : FocusTemplate.() -> Unit) : Bundle = createV2(block).buildBundle()

        @JvmStatic
        fun buildV3(consumer : Consumer<FocusTemplateV3>) : Bundle = createV3(consumer).buildBundle()

        @JvmSynthetic
        fun buildV3(block : FocusTemplateV3.() -> Unit) : Bundle = createV3(block).buildBundle()

        /* ====================================================
         * for custom focus style
         * ==================================================== */

        @JvmStatic
        fun createCustomV2(consumer : Consumer<CustomFocusTemplate>) : FocusNotification = createCustomV2 {
            consumer.accept(this)
        }

        @JvmSynthetic
        fun createCustomV2(block : CustomFocusTemplate.() -> Unit) : FocusNotification = FocusNotification().apply {
            focusVersion = 2
            isCustomFocus = true
            factory = FocusTemplateFactory.CustomV2(
                CustomFocusTemplate().also {
                    it.configWith(this)
                    it.block()
                }
            )
        }

        @JvmStatic
        fun createCustomV3(consumer : Consumer<CustomFocusTemplateV3>) : FocusNotification = createCustomV3 {
            consumer.accept(this)
        }

        @JvmSynthetic
        fun createCustomV3(block : CustomFocusTemplateV3.() -> Unit) : FocusNotification = FocusNotification().apply {
            focusVersion = 3
            isCustomFocus = true
            factory = FocusTemplateFactory.CustomV3(
                CustomFocusTemplateV3().also {
                    it.configWith(this)
                    it.block()
                }
            )
        }

        @JvmStatic
        fun buildCustomV2(consumer : Consumer<CustomFocusTemplate>) : Bundle = createCustomV2(consumer).buildBundle()

        @JvmSynthetic
        fun buildCustomV2(block : CustomFocusTemplate.() -> Unit) : Bundle = createCustomV2(block).buildBundle()

        @JvmStatic
        fun buildCustomV3(consumer : Consumer<CustomFocusTemplateV3>) : Bundle = createCustomV3(consumer).buildBundle()

        @JvmSynthetic
        fun buildCustomV3(block : CustomFocusTemplateV3.() -> Unit) : Bundle = createCustomV3(block).buildBundle()
    }

    @Serializable
    internal sealed class FocusTemplateFactory {
        @Serializable
        class V2(@SerialName("param_v2") val param : FocusTemplate) : FocusTemplateFactory()

        @Serializable
        class V3(@SerialName("param_v2") val param : FocusTemplateV3) : FocusTemplateFactory()

        @Serializable
        class CustomV2(val param : CustomFocusTemplate) : FocusTemplateFactory()

        @Serializable
        class CustomV3(val param : CustomFocusTemplateV3) : FocusTemplateFactory()
    }
}
