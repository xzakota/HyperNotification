package com.xzakota.hyper.notification.focus

import android.os.Bundle
import android.os.Parcelable
import com.xzakota.hyper.notification.focus.template.BaseFocusTemplate
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplate
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplateV3
import com.xzakota.hyper.notification.focus.template.FocusTemplate
import com.xzakota.hyper.notification.focus.template.FocusTemplateV3
import com.xzakota.hyper.notification.focus.util.JSONUtils
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Suppress("unused", "MemberVisibilityCanBePrivate")
class FocusNotification @PublishedApi internal constructor() {
    @PublishedApi
    internal lateinit var factory : FocusTemplateFactory
    @PublishedApi
    internal var focusVersion = -1
    private var pics : MutableMap<String, Parcelable?>? = null
    private var actions : MutableMap<String, Parcelable?>? = null

    fun buildBundle() : Bundle = Bundle().apply {
        when (factory) {
            is FocusTemplateFactory.CustomV2,
            is FocusTemplateFactory.CustomV3 -> {
                val param = factory.param as CustomFocusTemplate
                putString("miui.focus.param.custom", JSONUtils.toJSONString(param))
                param.rv.forEach { (k, v) ->
                    putParcelable(k, v)
                }
            }

            else -> putString("miui.focus.param", getFactoryJSON())
        }

        pics?.takeIf { it.isNotEmpty() }?.let { map ->
            putBundle("miui.focus.pics", buildPicsBundle(map))
        }

        actions?.takeIf { it.isNotEmpty() }?.let { map ->
            putBundle("miui.focus.actions", buildActionsBundle(map))
        }
    }

    fun getFactoryJSON() : String = JSONUtils.toJSONString(factory)

    internal fun createPicture(key : String, value : Parcelable) : String = key.also {
        (pics ?: mutableMapOf<String, Parcelable?>().also { map -> pics = map })[it] = value
    }

    internal fun createAction(key : String, value : Parcelable) : String = key.also {
        (actions ?: mutableMapOf<String, Parcelable?>().also { map -> actions = map })[it] = value
    }

    private fun buildPicsBundle(map : Map<String, Parcelable?>) : Bundle = Bundle().apply {
        map.forEach { (k, v) ->
            putParcelable(k, v)
        }
    }

    private fun buildActionsBundle(map : Map<String, Parcelable?>) : Bundle = Bundle().apply {
        map.forEach { (k, v) ->
            putParcelable(k, v)
        }
    }

    override fun toString() : String = "factory => ${getFactoryJSON()}, pics(${pics?.size ?: 0}) => ${pics?.keys}"

    companion object {
        /* ====================================================
         * for default focus style
         * ==================================================== */

        @JvmStatic
        inline fun createV2(crossinline block : FocusTemplate.() -> Unit) : FocusNotification = FocusNotification().apply {
            focusVersion = 2
            factory = FocusTemplateFactory.V2(
                FocusTemplate().also {
                    it.configWith(this)
                    it.block()
                }
            )
        }

        @JvmStatic
        inline fun createV3(crossinline block : FocusTemplateV3.() -> Unit) : FocusNotification = FocusNotification().apply {
            focusVersion = 3
            factory = FocusTemplateFactory.V3(
                FocusTemplateV3().also {
                    it.configWith(this)
                    it.block()
                }
            )
        }

        @JvmStatic
        inline fun buildV2(crossinline block : FocusTemplate.() -> Unit) : Bundle = createV2(block).buildBundle()

        @JvmStatic
        inline fun buildV3(crossinline block : FocusTemplateV3.() -> Unit) : Bundle = createV3(block).buildBundle()

        /* ====================================================
         * for custom focus style
         * ==================================================== */

        @JvmStatic
        inline fun createCustomV2(crossinline block : CustomFocusTemplate.() -> Unit) : FocusNotification = FocusNotification().apply {
            focusVersion = 2
            factory = FocusTemplateFactory.CustomV2(
                CustomFocusTemplate().also {
                    it.configWith(this)
                    it.block()
                }
            )
        }

        @JvmStatic
        inline fun createCustomV3(crossinline block : CustomFocusTemplateV3.() -> Unit) : FocusNotification = FocusNotification().apply {
            focusVersion = 3
            factory = FocusTemplateFactory.CustomV3(
                CustomFocusTemplateV3().also {
                    it.configWith(this)
                    it.block()
                }
            )
        }

        @JvmStatic
        inline fun buildCustomV2(crossinline block : CustomFocusTemplate.() -> Unit) : Bundle = createCustomV2(block).buildBundle()

        @JvmStatic
        inline fun buildCustomV3(crossinline block : CustomFocusTemplateV3.() -> Unit) : Bundle = createCustomV3(block).buildBundle()
    }

    @PublishedApi
    @Serializable
    internal sealed class FocusTemplateFactory(@Transient open val param : BaseFocusTemplate? = null) {
        @Serializable
        class V2(@SerialName("param_v2") override val param : FocusTemplate) : FocusTemplateFactory(param)

        @Serializable
        class V3(@SerialName("param_v2") override val param : FocusTemplateV3) : FocusTemplateFactory(param)

        @Serializable
        class CustomV2(override val param : CustomFocusTemplate) : FocusTemplateFactory(param)

        @Serializable
        class CustomV3(override val param : CustomFocusTemplateV3) : FocusTemplateFactory(param)
    }
}
