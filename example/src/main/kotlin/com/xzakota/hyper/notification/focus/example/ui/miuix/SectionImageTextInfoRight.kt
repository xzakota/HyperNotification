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

import com.xzakota.hyper.notification.focus.example.core.ImagePickerAndProcessor

@Composable
fun SectionImageTextInfoRight(
    state: NotificationState
) {
    val selection = state.islandRightSelection
    val isStyle3 = selection == "imageTextInfoRight3"

    Column {
        val titleText = if (isStyle3) "大岛右侧图文配置 (样式3)" else "大岛右侧图文配置"
        SmallTitle(text = titleText)
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            ImagePickerPreference(
                title = "pic",
                summary = "图标 (建议 128*88px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.ISLAND_RIGHT_PIC,
                currentPath = state.islandRightPic,
                onPathChange = { state.islandRightPic = it }
            )
            if (!isStyle3) {
                TextField(
                    value = state.islandRightFrontTitle,
                    onValueChange = { state.islandRightFrontTitle = it },
                    label = "frontTitle (前置小字)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
            TextField(
                value = state.islandRightTitle,
                onValueChange = { state.islandRightTitle = it },
                label = "title (大字)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            if (!isStyle3) {
                TextField(
                    value = state.islandRightContent,
                    onValueChange = { state.islandRightContent = it },
                    label = "content (后置小字)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
            SwitchPreference(
                title = "showHighlightColor",
                summary = "是否使用强调色",
                checked = state.islandRightShowHighlightVal,
                onCheckedChange = { state.islandRightShowHighlightVal = it }
            )
            SwitchPreference(
                title = "narrowFont",
                summary = "是否使用窄字体",
                checked = state.islandRightNarrowFontVal,
                onCheckedChange = { state.islandRightNarrowFontVal = it }
            )
        }
    }
}
