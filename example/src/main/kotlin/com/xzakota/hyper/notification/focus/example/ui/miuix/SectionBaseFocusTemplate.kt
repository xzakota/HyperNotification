package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.TextField
import top.yukonga.miuix.kmp.preference.SwitchPreference

@Composable
fun SectionBaseFocusTemplate(
    tickerText: String,
    onTickerChange: (String) -> Unit,
    tickerPicDark: String,
    onTickerPicDarkChange: (String) -> Unit,
    showSmallIconVal: Boolean,
    onShowSmallIconChange: (Boolean) -> Unit,
    timeoutText: String,
    onTimeoutChange: (String) -> Unit,
    updatableVal: Boolean,
    onUpdatableChange: (Boolean) -> Unit,
    enableFloatVal: Boolean,
    onEnableFloatChange: (Boolean) -> Unit,
    aodPicText: String,
    onAodPicChange: (String) -> Unit,
    aodTitleText: String,
    onAodTitleChange: (String) -> Unit,
    reopenText: String,
    onReopenChange: (String) -> Unit,
    filterWhenNoPermissionVal: Boolean,
    onFilterWhenNoPermissionChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .padding(bottom = 12.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = tickerText,
            onValueChange = onTickerChange,
            label = "ticker (OS2 状态栏提示文案)",
            modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 12.dp)
        )
        TextField(
            value = tickerPicDark,
            onValueChange = onTickerPicDarkChange,
            label = "tickerPicDark (OS2 状态栏深色模式图标)",
            modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
        )
        TextField(
            value = timeoutText,
            onValueChange = onTimeoutChange,
            label = "timeout (min)",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
        )
        TextField(
            value = aodPicText,
            onValueChange = onAodPicChange,
            label = "aodPic (息屏模式图标)",
            modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
        )
        TextField(
            value = aodTitleText,
            onValueChange = onAodTitleChange,
            label = "aodTitle (息屏通知标题)",
            modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
        )
        TextField(
            value = reopenText,
            onValueChange = onReopenChange,
            label = "reopen (相同 ID 被 cancel 后再次发送是否显示，reopen/close)",
            modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
        )
        SwitchPreference(
            title = "showSmallIcon",
            checked = showSmallIconVal,
            onCheckedChange = onShowSmallIconChange,
            summary = "是否显示通知的常规小图标"
        )
        SwitchPreference(
            title = "updatable",
            checked = updatableVal,
            onCheckedChange = onUpdatableChange,
            summary = "是否为持续性通知（如打车、外卖等需要持续更新的，默认值 false）"
        )
        SwitchPreference(
            title = "enableFloat",
            checked = enableFloatVal,
            onCheckedChange = onEnableFloatChange,
            summary = "通知更新时，是否自动展开为展开态（true:展开，false:不展开，默认值 false）"
        )
        SwitchPreference(
            title = "filterWhenNoPermission",
            checked = filterWhenNoPermissionVal,
            onCheckedChange = onFilterWhenNoPermissionChange,
            summary = "权限关闭时退化处理方式（false:正常显示不被过滤，true:过滤且不显示，默认值 false）"
        )
    }
}
