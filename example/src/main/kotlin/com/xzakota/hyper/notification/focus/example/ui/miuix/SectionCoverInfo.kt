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
fun SectionCoverInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "picCover (封面图)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            ImagePickerPreference(
                title = "picCover",
                summary = "封面图 (建议 224*288px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.COVER_PIC_COVER,
                currentPath = state.coverPicCover,
                onPathChange = { state.coverPicCover = it }
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
                value = state.coverTitle,
                onValueChange = { state.coverTitle = it },
                label = "title",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.coverColorTitle,
                onValueChange = { state.coverColorTitle = it },
                label = "colorTitle (Hex, e.g. #FF5722)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.coverColorTitleDark,
                onValueChange = { state.coverColorTitleDark = it },
                label = "colorTitleDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "content (次要文本 1)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.coverContent,
                onValueChange = { state.coverContent = it },
                label = "content",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.coverColorContent,
                onValueChange = { state.coverColorContent = it },
                label = "colorContent (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.coverColorContentDark,
                onValueChange = { state.coverColorContentDark = it },
                label = "colorContentDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "subContent (次要文本 2)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.coverSubContent,
                onValueChange = { state.coverSubContent = it },
                label = "subContent",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.coverColorSubContent,
                onValueChange = { state.coverColorSubContent = it },
                label = "colorSubContent (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.coverColorSubContentDark,
                onValueChange = { state.coverColorSubContentDark = it },
                label = "colorSubContentDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
    }
}
