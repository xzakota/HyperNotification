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
            TextField(
                value = state.picForward,
                onValueChange = { state.picForward = it },
                label = "picForward (前进移动图形 Key/URI)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.picMiddle,
                onValueChange = { state.picMiddle = it },
                label = "picMiddle (中点图形 - 进度通过)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.picMiddleUnselected,
                onValueChange = { state.picMiddleUnselected = it },
                label = "picMiddleUnselected (中点图形 - 未通过)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.picEnd,
                onValueChange = { state.picEnd = it },
                label = "picEnd (终点图形 - 进度通过)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.picEndUnselected,
                onValueChange = { state.picEndUnselected = it },
                label = "picEndUnselected (终点图形 - 未通过)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
    }
}
