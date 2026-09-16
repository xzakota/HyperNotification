package com.xzakota.hyper.notification.focus

import android.os.Bundle
import com.xzakota.hyper.notification.focus.extension.buildBundle
import com.xzakota.hyper.notification.focus.template.BaseFocusTemplate
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplate
import com.xzakota.hyper.notification.focus.template.CustomFocusTemplateV3
import com.xzakota.hyper.notification.focus.template.FocusTemplate
import com.xzakota.hyper.notification.focus.template.FocusTemplateV3
import com.xzakota.hyper.notification.focus.util.JSONUtils
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Suppress("unused")
class FocusNotification @PublishedApi internal constructor(private var factory : FocusTemplateFactory) {
    fun buildBundle() : Bundle = buildBundle {
        val param = factory.param ?: return@buildBundle
        when (param) {
            is CustomFocusTemplate -> {
                putString("miui.focus.param.custom", JSONUtils.toJSONString(param))
                param.handleRemoteViewsIn(this)
            }

            else -> putString("miui.focus.param", getFactoryJSON())
        }

        param.handlePictures {
            putBundle("miui.focus.pics", it)
        }

        param.handleActions {
            putBundle("miui.focus.actions", it)
        }
    }

    fun getFactoryJSON() : String = JSONUtils.toJSONString(factory)

    override fun toString() : String = "factory => ${getFactoryJSON()}"

    companion object {
        /* ====================================================
         * for default focus style
         * ==================================================== */

        @JvmStatic
        inline fun createV2(
            crossinline block : FocusTemplate.() -> Unit
        ) : FocusNotification = FocusNotification(
            FocusTemplateFactory.V2(
                FocusTemplate().also(block)
            )
        )

        @JvmStatic
        inline fun createV3(
            crossinline block : FocusTemplateV3.() -> Unit
        ) : FocusNotification = FocusNotification(
            FocusTemplateFactory.V3(
                FocusTemplateV3().also(block)
            )
        )

        @JvmStatic
        inline fun buildV2(crossinline block : FocusTemplate.() -> Unit) : Bundle = createV2(block).buildBundle()

        @JvmStatic
        inline fun buildV3(crossinline block : FocusTemplateV3.() -> Unit) : Bundle = createV3(block).buildBundle()

        /* ====================================================
         * for custom focus style
         * ==================================================== */

        @JvmStatic
        inline fun createCustomV2(
            crossinline block : CustomFocusTemplate.() -> Unit
        ) : FocusNotification = FocusNotification(
            FocusTemplateFactory.CustomV2(
                CustomFocusTemplate().also(block)
            )
        )

        @JvmStatic
        inline fun createCustomV3(
            crossinline block : CustomFocusTemplateV3.() -> Unit
        ) : FocusNotification = FocusNotification(
            FocusTemplateFactory.CustomV3(
                CustomFocusTemplateV3().also(block)
            )
        )

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
