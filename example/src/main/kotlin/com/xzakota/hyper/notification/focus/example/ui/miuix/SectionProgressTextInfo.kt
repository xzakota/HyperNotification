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
import top.yukonga.miuix.kmp.preference.SwitchPreference

@Composable
fun SectionProgressTextInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "大岛右侧进度文本配置 (progressTextInfo)")
        
        SmallTitle(text = "进度条信息 (progressInfo)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.islandRightProgress,
                onValueChange = { state.islandRightProgress = it },
                label = "progress (当前进度: 0-100)",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.islandRightColorReach,
                onValueChange = { state.islandRightColorReach = it },
                label = "colorReach (进度通过颜色 Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.islandRightColorUnReach,
                onValueChange = { state.islandRightColorUnReach = it },
                label = "colorUnReach (进度未通过颜色 Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            SwitchPreference(
                title = "isCCW (逆时针/起始位置)",
                summary = "关闭 3点钟方向 / 开启 12点钟方向",
                checked = state.islandRightIsCCW,
                onCheckedChange = { state.islandRightIsCCW = it }
            )
        }

        SmallTitle(text = "文字信息 (textInfo)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.islandRightFrontTitle,
                onValueChange = { state.islandRightFrontTitle = it },
                label = "frontTitle (前置小字)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.islandRightTitle,
                onValueChange = { state.islandRightTitle = it },
                label = "title (大字)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.islandRightContent,
                onValueChange = { state.islandRightContent = it },
                label = "content (后置小字)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
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
