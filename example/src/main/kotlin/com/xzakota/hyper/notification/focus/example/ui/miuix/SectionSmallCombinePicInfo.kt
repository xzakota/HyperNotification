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
fun SectionSmallCombinePicInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "摘要小岛组合图标配置 (combinePicInfo)")
        
        SmallTitle(text = "图标信息 (picInfo)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.islandSmallPic,
                onValueChange = { state.islandSmallPic = it },
                label = "pic (图标)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "进度条信息 (progressInfo)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.islandSmallProgress,
                onValueChange = { state.islandSmallProgress = it },
                label = "progress (当前进度: 0-100)",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.islandSmallColorReach,
                onValueChange = { state.islandSmallColorReach = it },
                label = "colorReach (进度通过颜色 Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.islandSmallColorUnReach,
                onValueChange = { state.islandSmallColorUnReach = it },
                label = "colorUnReach (进度未通过颜色 Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            SwitchPreference(
                title = "isCCW (逆时针/起始位置)",
                summary = "关闭 3点钟方向 / 开启 12点钟方向",
                checked = state.islandSmallIsCCW,
                onCheckedChange = { state.islandSmallIsCCW = it }
            )
        }
    }
}
