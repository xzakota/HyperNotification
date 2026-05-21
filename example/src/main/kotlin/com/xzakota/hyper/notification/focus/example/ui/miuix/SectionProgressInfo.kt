package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.TextField

import com.xzakota.hyper.notification.focus.example.core.ImagePickerAndProcessor

@Composable
fun SectionProgressInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "进度基础参数 (progressInfo)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.progressText,
                onValueChange = { state.progressText = it },
                label = "progress (当前进度 Int, e.g. 40)",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.colorProgress,
                onValueChange = { state.colorProgress = it },
                label = "colorProgress",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.colorProgressEnd,
                onValueChange = { state.colorProgressEnd = it },
                label = "colorProgressEnd",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "进度条相关图标与图形配置")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            ImagePickerPreference(
                title = "picForward",
                summary = "前进移动图形 (建议 240*188px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.PROGRESS_FORWARD,
                currentPath = state.picForward,
                onPathChange = { state.picForward = it }
            )
            ImagePickerPreference(
                title = "picMiddle",
                summary = "中点图形 - 已通过 (建议 120*188px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.PROGRESS_MIDDLE_END,
                currentPath = state.picMiddle,
                onPathChange = { state.picMiddle = it }
            )
            ImagePickerPreference(
                title = "picMiddleUnselected",
                summary = "中点图形 - 未通过 (建议 120*188px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.PROGRESS_MIDDLE_END,
                currentPath = state.picMiddleUnselected,
                onPathChange = { state.picMiddleUnselected = it }
            )
            ImagePickerPreference(
                title = "picEnd",
                summary = "终点图形 - 已通过 (建议 120*188px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.PROGRESS_MIDDLE_END,
                currentPath = state.picEnd,
                onPathChange = { state.picEnd = it }
            )
            ImagePickerPreference(
                title = "picEndUnselected",
                summary = "终点图形 - 未通过 (建议 120*188px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.PROGRESS_MIDDLE_END,
                currentPath = state.picEndUnselected,
                onPathChange = { state.picEndUnselected = it }
            )
        }
    }
}
