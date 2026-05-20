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
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference
import top.yukonga.miuix.kmp.preference.SwitchPreference

@Composable
fun SectionActionInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "actionInfo (动作组件)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            val actionTypeSelectedIndex = when (state.actionType) {
                "1" -> 1
                "2" -> 2
                else -> 0
            }
            OverlayDropdownPreference(
                title = "type (按钮类型)",
                items = listOf("圆形 (0)", "进度 (1)", "文字 (2)"),
                selectedIndex = actionTypeSelectedIndex,
                onSelectedIndexChange = { index ->
                    state.actionType = index.toString()
                }
            )

            OverlayDropdownPreference(
                title = "构建方式选择",
                items = listOf("方式一：miui.focus.actions 中的 Action", "方式二：自定义构建 Action"),
                selectedIndex = state.actionWayIndex,
                onSelectedIndexChange = { state.actionWayIndex = it }
            )

            SwitchPreference(
                title = "clickWithCollapse (点击是否收起)",
                summary = "动作触发后是否自动收起系统下拉通知栏面板",
                checked = state.actionClickWithCollapse,
                onCheckedChange = { state.actionClickWithCollapse = it }
            )
        }

        if (state.actionWayIndex == 0) {
            SmallTitle(text = "方式一：预定义动作配置")
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = state.action,
                    onValueChange = { state.action = it },
                    label = "action (系统预定义 Action)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                if (state.actionType == "2") {
                    TextField(
                        value = state.actionTitle,
                        onValueChange = { state.actionTitle = it },
                        label = "actionTitle (按钮文案 - 预定义文字按钮必填)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }
        } else {
            SmallTitle(text = "方式二：自定义动作配置")
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = state.actionIcon,
                    onValueChange = { state.actionIcon = it },
                    label = "actionIcon (按钮图标 Key/URI)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.actionIconDark,
                    onValueChange = { state.actionIconDark = it },
                    label = "actionIconDark (暗色按钮图标)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.actionTitle,
                    onValueChange = { state.actionTitle = it },
                    label = "actionTitle (按钮文案)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.actionTitleColor,
                    onValueChange = { state.actionTitleColor = it },
                    label = "actionTitleColor (文字颜色 Hex)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.actionTitleColorDark,
                    onValueChange = { state.actionTitleColorDark = it },
                    label = "actionTitleColorDark (暗色文字颜色)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.actionBgColor,
                    onValueChange = { state.actionBgColor = it },
                    label = "actionBgColor (背景颜色 Hex)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.actionBgColorDark,
                    onValueChange = { state.actionBgColorDark = it },
                    label = "actionBgColorDark (暗色背景颜色)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.actionIntentType,
                    onValueChange = { state.actionIntentType = it },
                    label = "actionIntentType (跳转类型: 1 Activity / 2 Broadcast / 3 Service)",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.actionIntent,
                    onValueChange = { state.actionIntent = it },
                    label = "actionIntent (自定义跳转 Intent URI)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}
