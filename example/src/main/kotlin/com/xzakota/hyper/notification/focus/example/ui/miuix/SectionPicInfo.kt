package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.TextField
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference
import top.yukonga.miuix.kmp.preference.SwitchPreference

@Composable
fun SectionPicInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "picInfo (识别图形组件)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            val picTypeSelectedIndex = when (state.picType) {
                "2" -> 1
                "3" -> 2
                "5" -> 3
                else -> 0
            }

            OverlayDropdownPreference(
                title = "type (标记组件类型)",
                items = listOf("appIcon (1)", "middle (2)", "large (3)", "countdown (5)"),
                selectedIndex = picTypeSelectedIndex,
                onSelectedIndexChange = { index ->
                    state.picType = when (index) {
                        1 -> "2"
                        2 -> "3"
                        3 -> "5"
                        else -> "1"
                    }
                }
            )

            TextField(
                value = state.pic,
                onValueChange = { state.pic = it },
                label = "pic (应用图标 / 功能图标 / 图片)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.picDark,
                onValueChange = { state.picDark = it },
                label = "picDark (深色图片资源)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )

            if (state.picType != "5") {
                SwitchPreference(
                    title = "actionInfo (动作组件)",
                    checked = state.showActionInfo,
                    onCheckedChange = { state.showActionInfo = it }
                )
            }
        }

        if (state.picType == "5") {
            SmallTitle(text = "倒计时专属配置 (type 5)")
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = state.picTitle,
                    onValueChange = { state.picTitle = it },
                    label = "title (组件文字, 如红绿灯计时数字)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.picColorTitle,
                    onValueChange = { state.picColorTitle = it },
                    label = "colorTitle (文字颜色 Hex, e.g. #cc234567)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }

        if (state.picType != "5" && state.showActionInfo) {
            SectionActionInfo(state = state)
        }
    }
}
