package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.basic.TextField
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference
import top.yukonga.miuix.kmp.preference.SwitchPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun SectionActions(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "actions (按钮组组件)")

        state.actionsList.forEachIndexed { index, actionState ->
            SmallTitle(text = "按钮配置 #${index + 1}")
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                val actionTypeSelectedIndex = when (actionState.type) {
                    "1" -> 1
                    "2" -> 2
                    else -> 0
                }
                OverlayDropdownPreference(
                    title = "type (按钮类型)",
                    items = listOf("圆形 (0)", "进度 (1)", "文字 (2)"),
                    selectedIndex = actionTypeSelectedIndex,
                    onSelectedIndexChange = { idx ->
                        actionState.type = idx.toString()
                    }
                )

                OverlayDropdownPreference(
                    title = "构建方式选择",
                    items = listOf("方式一：miui.focus.actions 中的 Action", "方式二：自定义构建 Action"),
                    selectedIndex = actionState.actionWayIndex,
                    onSelectedIndexChange = { actionState.actionWayIndex = it }
                )

                SwitchPreference(
                    title = "clickWithCollapse (点击是否收起)",
                    summary = "动作触发后是否自动收起系统下拉通知栏面板",
                    checked = actionState.clickWithCollapse,
                    onCheckedChange = { actionState.clickWithCollapse = it }
                )

                if (actionState.type == "1") {
                    SmallTitle(text = "进度条配置 (progressInfo)")
                    TextField(
                        value = actionState.progress,
                        onValueChange = { actionState.progress = it },
                        label = "progress (当前进度: 0-100)",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = actionState.colorProgress,
                        onValueChange = { actionState.colorProgress = it },
                        label = "colorProgress (进度条起始颜色 Hex)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    SwitchPreference(
                        title = "isCCW (起始位置)",
                        summary = "关闭 3点钟方向 / 开启 12点钟方向",
                        checked = actionState.isCCW,
                        onCheckedChange = { actionState.isCCW = it }
                    )
                    SwitchPreference(
                        title = "isAutoProgress (是否自更新)",
                        summary = "是否开启自增长进度条",
                        checked = actionState.isAutoProgress,
                        onCheckedChange = { actionState.isAutoProgress = it }
                    )
                }

                if (actionState.actionWayIndex == 0) {
                    SmallTitle(text = "方式一：预定义动作")
                    TextField(
                        value = actionState.action,
                        onValueChange = { actionState.action = it },
                        label = "action (系统预定义 Action)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    if (actionState.type == "2") {
                        TextField(
                            value = actionState.actionTitle,
                            onValueChange = { actionState.actionTitle = it },
                            label = "actionTitle (按钮文案 - 预定义文字按钮必填)",
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                } else {
                    SmallTitle(text = "方式二：自定义动作")
                    TextField(
                        value = actionState.actionIcon,
                        onValueChange = { actionState.actionIcon = it },
                        label = "actionIcon (按钮图标 Key/URI)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = actionState.actionIconDark,
                        onValueChange = { actionState.actionIconDark = it },
                        label = "actionIconDark (暗色按钮图标)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = actionState.actionTitle,
                        onValueChange = { actionState.actionTitle = it },
                        label = "actionTitle (按钮文案)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = actionState.actionTitleColor,
                        onValueChange = { actionState.actionTitleColor = it },
                        label = "actionTitleColor (文字颜色 Hex)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = actionState.actionTitleColorDark,
                        onValueChange = { actionState.actionTitleColorDark = it },
                        label = "actionTitleColorDark (暗色文字颜色)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = actionState.actionBgColor,
                        onValueChange = { actionState.actionBgColor = it },
                        label = "actionBgColor (背景颜色 Hex)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = actionState.actionBgColorDark,
                        onValueChange = { actionState.actionBgColorDark = it },
                        label = "actionBgColorDark (暗色背景颜色)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = actionState.actionIntentType,
                        onValueChange = { actionState.actionIntentType = it },
                        label = "actionIntentType (跳转类型: 1 Activity / 2 Broadcast / 3 Service)",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = actionState.actionIntent,
                        onValueChange = { actionState.actionIntent = it },
                        label = "actionIntent (自定义跳转 Intent URI)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }

                if (state.actionsList.size > 1) {
                    Button(
                        onClick = {
                            state.actionsList.removeAt(index)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Text("删除此按钮")
                    }
                }
            }
        }

        if (state.actionsList.size < 3) {
            Button(
                onClick = {
                    state.actionsList.add(ActionState())
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
            ) {
                Text("添加动作按钮 (最多3个)")
            }
        }
    }
}
