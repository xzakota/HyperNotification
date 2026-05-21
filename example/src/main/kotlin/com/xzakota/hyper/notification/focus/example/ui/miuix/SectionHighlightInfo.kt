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
fun SectionHighlightInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "picFunction")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.highlightPicFunction,
                onValueChange = { state.highlightPicFunction = it },
                label = "picFunction (功能图标 URI / Key)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightPicFunctionDark,
                onValueChange = { state.highlightPicFunctionDark = it },
                label = "picFunctionDark (深色模式功能图标)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "强调信息")
        val hideTypeItems = listOf(
            "不隐藏",
            "1 (隐藏辅助文本 1)"
        )
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            OverlayDropdownPreference(
                title = "展示类型",
                items = listOf("title (强调文本)", "timerInfo (计时信息)"),
                selectedIndex = if (state.showTimerInfo) 1 else 0,
                onSelectedIndexChange = { index ->
                    state.showTimerInfo = index == 1
                }
            )
            OverlayDropdownPreference(
                title = "type (是否隐藏辅助文本1)",
                items = hideTypeItems,
                selectedIndex = state.highlightTypeVal.coerceIn(0, 1),
                onSelectedIndexChange = { index ->
                    state.highlightTypeVal = index
                }
            )
        }

        if (!state.showTimerInfo) {
            SmallTitle(text = "title (强调文本)")
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = state.highlightTitle,
                    onValueChange = { state.highlightTitle = it },
                    label = "title",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.highlightColorTitle,
                    onValueChange = { state.highlightColorTitle = it },
                    label = "colorTitle (Hex, e.g. #FF9800)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.highlightColorTitleDark,
                    onValueChange = { state.highlightColorTitleDark = it },
                    label = "colorTitleDark (Hex)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        } else {
            SectionTimerInfo(state = state)
        }

        SmallTitle(text = "content (辅助文本 1)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.highlightContent,
                onValueChange = { state.highlightContent = it },
                label = "content",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightColorContent,
                onValueChange = { state.highlightColorContent = it },
                label = "colorContent (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightColorContentDark,
                onValueChange = { state.highlightColorContentDark = it },
                label = "colorContentDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "subContent (辅助文本 2)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.highlightSubContent,
                onValueChange = { state.highlightSubContent = it },
                label = "subContent",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightColorSubContent,
                onValueChange = { state.highlightColorSubContent = it },
                label = "colorSubContent (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightColorSubContentDark,
                onValueChange = { state.highlightColorSubContentDark = it },
                label = "colorSubContentDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
    }
}
