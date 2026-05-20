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
fun SectionBgInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "bgInfo (背景组件)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            OverlayDropdownPreference(
                title = "type",
                items = listOf("全屏 (1)", "右侧 (2)"),
                selectedIndex = if (state.bgType == "2") 1 else 0,
                onSelectedIndexChange = { index ->
                    state.bgType = if (index == 1) "2" else "1"
                }
            )
            TextField(
                value = state.colorBg,
                onValueChange = { state.colorBg = it },
                label = "colorBg (背景色 Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.picBg,
                onValueChange = { state.picBg = it },
                label = "picBg (背景图 Key/URI)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
    }
}
