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

import com.xzakota.hyper.notification.focus.example.core.ImagePickerAndProcessor

@Composable
fun SectionChatInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "图标类")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            ImagePickerPreference(
                title = "picProfile",
                summary = "头像类图片 (建议 224*224px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.CHAT_PIC_PROFILE,
                currentPath = state.chatPicProfile,
                onPathChange = { state.chatPicProfile = it }
            )
            ImagePickerPreference(
                title = "picProfileDark",
                summary = "深色头像类图片 (建议 224*224px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.CHAT_PIC_PROFILE,
                currentPath = state.chatPicProfileDark,
                onPathChange = { state.chatPicProfileDark = it }
            )
            ImagePickerPreference(
                title = "appIconPkg",
                summary = "自定义应用图标 (建议 96*96px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.CHAT_APP_ICON_PKG,
                currentPath = state.chatAppIconPkg,
                onPathChange = { state.chatAppIconPkg = it }
            )
        }

        SmallTitle(text = "title (主要文本)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.chatTitle,
                onValueChange = { state.chatTitle = it },
                label = "title",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.chatColorTitle,
                onValueChange = { state.chatColorTitle = it },
                label = "colorTitle (Hex, e.g. #FF5722)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.chatColorTitleDark,
                onValueChange = { state.chatColorTitleDark = it },
                label = "colorTitleDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "次要显示内容类型")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            OverlayDropdownPreference(
                title = "展示类型",
                items = listOf("content (文字内容)", "timerInfo (时间计时器)"),
                selectedIndex = if (state.showTimerInfo) 1 else 0,
                onSelectedIndexChange = { index ->
                    state.showTimerInfo = index == 1
                }
            )
        }

        if (!state.showTimerInfo) {
            SmallTitle(text = "content (次要文本)")
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = state.chatContent,
                    onValueChange = { state.chatContent = it },
                    label = "content",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.chatColorContent,
                    onValueChange = { state.chatColorContent = it },
                    label = "colorContent (Hex)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.chatColorContentDark,
                    onValueChange = { state.chatColorContentDark = it },
                    label = "colorContentDark (Hex)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        } else {
            SectionTimerInfo(state = state)
        }
    }
}
