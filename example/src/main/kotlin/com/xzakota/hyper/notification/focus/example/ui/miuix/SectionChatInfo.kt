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
            TextField(
                value = state.chatPicProfile,
                onValueChange = { state.chatPicProfile = it },
                label = "picProfile (头像类图片 URI / Key)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.chatPicProfileDark,
                onValueChange = { state.chatPicProfileDark = it },
                label = "picProfileDark (深色模式图片)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.chatAppIconPkg,
                onValueChange = { state.chatAppIconPkg = it },
                label = "appIconPkg (自定义应用图标)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
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
