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
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.TextField
import top.yukonga.miuix.kmp.preference.SwitchPreference

@Composable
fun SectionIExtraV3Param(
    cancelVal: Boolean,
    onCancelChange: (Boolean) -> Unit,
    hideDecoVal: Boolean,
    onHideDecoChange: (Boolean) -> Unit,
    isShowNotificationVal: Boolean,
    onIsShowNotificationChange: (Boolean) -> Unit,
    islandFirstFloatVal: Boolean,
    onIslandFirstFloatChange: (Boolean) -> Unit,
    outEffectColor: String,
    onOutEffectColorChange: (String) -> Unit,
    outEffectSrc: String,
    onOutEffectSrcChange: (String) -> Unit,
    sequenceText: String,
    onSequenceChange: (String) -> Unit,
    businessText: String,
    onBusinessChange: (String) -> Unit,
    notifyIdText: String,
    onNotifyIdChange: (String) -> Unit,
    orderIdText: String,
    onOrderIdChange: (String) -> Unit
) {
    Column {
        SmallTitle(text = "V3 专属系统配置 (IExtraV3Param)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = sequenceText,
                onValueChange = onSequenceChange,
                label = "sequence (Long)",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 12.dp)
            )
            TextField(
                value = outEffectColor,
                onValueChange = onOutEffectColorChange,
                label = "outEffectColor",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            )
            TextField(
                value = outEffectSrc,
                onValueChange = onOutEffectSrcChange,
                label = "outEffectSrc (Light Ring Effect)",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            )
            TextField(
                value = businessText,
                onValueChange = onBusinessChange,
                label = "business",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            )
            TextField(
                value = notifyIdText,
                onValueChange = onNotifyIdChange,
                label = "notifyId",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            )
            TextField(
                value = orderIdText,
                onValueChange = onOrderIdChange,
                label = "orderId",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            )
            SwitchPreference(
                title = "cancel",
                summary = "是否直接结束通知（针对 mipush 触发移除通知）",
                checked = cancelVal,
                onCheckedChange = onCancelChange
            )
            SwitchPreference(
                title = "hideDeco",
                summary = "是否隐藏流海装饰栏（灵动岛胶囊旁边的系统图标）",
                checked = hideDecoVal,
                onCheckedChange = onHideDecoChange
            )
            SwitchPreference(
                title = "isShowNotification",
                summary = "是否在大岛展开时同时显示系统标准通知栏通知",
                checked = isShowNotificationVal,
                onCheckedChange = onIsShowNotificationChange
            )
            SwitchPreference(
                title = "islandFirstFloat",
                summary = "通知第一次出现时，是否自动显示展开态（默认开启）",
                checked = islandFirstFloatVal,
                onCheckedChange = onIslandFirstFloatChange
            )
        }
    }
}
