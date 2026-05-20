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
fun SectionImageTextInfoLeft(
    state: NotificationState
) {
    val selection = state.islandLeftSelection
    val isStyle5 = selection == "imageTextInfoLeft5"

    Column {
        val titleText = if (isStyle5) "大岛左侧图文配置 (样式5)" else "大岛左侧图文配置"
        SmallTitle(text = titleText)
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.islandLeftPic,
                onValueChange = { state.islandLeftPic = it },
                label = "pic (图标)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.islandLeftTitle,
                onValueChange = { state.islandLeftTitle = it },
                label = "title (大字)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.islandLeftContent,
                onValueChange = { state.islandLeftContent = it },
                label = "content (后置小字)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            SwitchPreference(
                title = "showHighlightColor",
                summary = "是否使用强调色",
                checked = state.islandLeftShowHighlightVal,
                onCheckedChange = { state.islandLeftShowHighlightVal = it }
            )
            if (!isStyle5) {
                SwitchPreference(
                    title = "narrowFont",
                    summary = "是否使用窄字体",
                    checked = state.islandLeftNarrowFontVal,
                    onCheckedChange = { state.islandLeftNarrowFontVal = it }
                )
            }
        }
    }
}
