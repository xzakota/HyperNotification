package com.xzakota.hyper.notification.focus.util

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.provider.Settings

@Suppress("unused")
object FocusUtils {
    /**
     * 查询当前 OS 支持的焦点通知版本
     *   - 1: OS1 版本, 支持 OS1 版本焦点通知模板
     *   - 2: OS2 版本, 支持 OS2 版本焦点通知模板
     *   - 3: OS3 版本, 支持 OS3 版本小米超级岛通知模板
     */
    @JvmStatic
    fun getFocusProtocolVersion(context: Context) : Int = Settings.System.getInt(context.contentResolver, "notification_focus_protocol", 0)

    /**
     * 查询当前 OS 是否支持超级岛功能
     */
    @JvmStatic
    fun isSupportIsland(): Boolean = PropUtils.getBoolean("persist.sys.feature.island", false)


    /**
     * 查询当前应用是否开启焦点通知权限(耗时操作)
     *
     * @return
     *   - OS1 之前无焦点通知功能的版本，返回 false
     *   - OS1 OS2 OS3 上, 焦点通知权限关闭时, 返回 false, 焦点通知权限打开时, 返回 true
     */
    @JvmStatic
    fun hasFocusPermission(context : Context) : Boolean = runCatching {
        val uri = Uri.parse("content://miui.statusbar.notification.public")
        val extras = Bundle().apply {
            putString("package", context.packageName)
        }

        val result = context.contentResolver.call(uri, "canShowFocus", null, extras)
        result?.getBoolean("canShowFocus", false) == true
    }.getOrDefault(false)
}
