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
import top.yukonga.miuix.kmp.preference.SwitchPreference

@Composable
fun SectionFixedWidthDigitInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "大岛右侧定宽数字配置 (fixedWidthDigitInfo)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.islandRightDigit,
                onValueChange = { state.islandRightDigit = it },
                label = "digit (定宽数字)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.islandRightContent,
                onValueChange = { state.islandRightContent = it },
                label = "content (小字)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            SwitchPreference(
                title = "showHighlightColor",
                summary = "是否使用强调色",
                checked = state.islandRightShowHighlightVal,
                onCheckedChange = { state.islandRightShowHighlightVal = it }
            )
        }
    }
}
