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

import com.xzakota.hyper.notification.focus.example.core.ImagePickerAndProcessor

@Composable
fun SectionSmallPicInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "摘要小岛单图标配置 (picInfo)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            ImagePickerPreference(
                title = "pic",
                summary = "图标 (建议 88*88px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.ISLAND_SMALL_PIC,
                currentPath = state.islandSmallPic,
                onPathChange = { state.islandSmallPic = it }
            )
        }
    }
}
