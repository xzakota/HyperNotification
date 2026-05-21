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

import com.xzakota.hyper.notification.focus.example.core.ImagePickerAndProcessor

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

            val spec = when (state.picType) {
                "2" -> ImagePickerAndProcessor.ImageSpec.PIC_INFO_TYPE_2
                "3" -> ImagePickerAndProcessor.ImageSpec.PIC_INFO_TYPE_3
                else -> ImagePickerAndProcessor.ImageSpec.PIC_INFO_TYPE_1_5
            }

            ImagePickerPreference(
                title = "pic",
                summary = "图片 (基于Type: ${spec.width}*${spec.height}px)",
                imageSpec = spec,
                currentPath = state.pic,
                onPathChange = { state.pic = it }
            )
            ImagePickerPreference(
                title = "picDark",
                summary = "深色图片 (基于Type: ${spec.width}*${spec.height}px)",
                imageSpec = spec,
                currentPath = state.picDark,
                onPathChange = { state.picDark = it }
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
