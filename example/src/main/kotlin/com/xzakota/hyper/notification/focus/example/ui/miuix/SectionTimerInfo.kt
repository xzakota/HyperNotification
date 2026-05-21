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
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference

@Composable
fun SectionTimerInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "timerInfo")
        val timerTypes = listOf(
            "-2 (倒计时暂停)",
            "-1 (倒计时开始)",
            "0 (默认值/无动作)",
            "1 (正计时开始)",
            "2 (正计时暂停)"
        )
        val timerTypeValues = listOf("-2", "-1", "0", "1", "2")
        val rawIndex = timerTypeValues.indexOf(state.timerType)
        val selectedIndex = if (rawIndex == -1) 2 else rawIndex

        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            OverlayDropdownPreference(
                title = "timerType (计时类型)",
                items = timerTypes,
                selectedIndex = selectedIndex,
                onSelectedIndexChange = { index ->
                    state.timerType = timerTypeValues[index]
                }
            )
            TextField(
                value = state.timerWhen,
                onValueChange = { state.timerWhen = it },
                label = "timerWhen (毫秒的时间戳)",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.timerTotal,
                onValueChange = { state.timerTotal = it },
                label = "timerTotal",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.timerSystemCurrent,
                onValueChange = { state.timerSystemCurrent = it },
                label = "timerSystemCurrent (毫秒的时间戳)",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
    }
}
