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
fun SectionHighlightInfoV3(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "primaryText (高亮文本)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.highlightV3PrimaryText,
                onValueChange = { state.highlightV3PrimaryText = it },
                label = "primaryText",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightV3PrimaryColor,
                onValueChange = { state.highlightV3PrimaryColor = it },
                label = "primaryColor (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightV3PrimaryColorDark,
                onValueChange = { state.highlightV3PrimaryColorDark = it },
                label = "primaryColorDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "secondaryText (补充文本)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.highlightV3SecondaryText,
                onValueChange = { state.highlightV3SecondaryText = it },
                label = "secondaryText",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightV3SecondaryColor,
                onValueChange = { state.highlightV3SecondaryColor = it },
                label = "secondaryColor (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightV3SecondaryColorDark,
                onValueChange = { state.highlightV3SecondaryColorDark = it },
                label = "secondaryColorDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            SwitchPreference(
                title = "showSecondaryLine (补充文本是否划线)",
                checked = state.highlightV3ShowSecondaryLine,
                onCheckedChange = { state.highlightV3ShowSecondaryLine = it }
            )
        }

        SmallTitle(text = "highLightText (文字标签)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.highlightV3HighLightText,
                onValueChange = { state.highlightV3HighLightText = it },
                label = "highLightText",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightV3HighLightTextColor,
                onValueChange = { state.highlightV3HighLightTextColor = it },
                label = "highLightTextColor (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightV3HighLightTextColorDark,
                onValueChange = { state.highlightV3HighLightTextColorDark = it },
                label = "highLightTextColorDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightV3HighLightBgColor,
                onValueChange = { state.highlightV3HighLightBgColor = it },
                label = "highLightbgColor (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.highlightV3HighLightBgColorDark,
                onValueChange = { state.highlightV3HighLightBgColorDark = it },
                label = "highLightbgColorDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            SwitchPreference(
                title = "actionInfo (圆头图文按钮)",
                checked = state.showActionInfo,
                onCheckedChange = { state.showActionInfo = it }
            )
        }

        if (state.showActionInfo) {
            SectionActionInfo(state = state)
        }
    }
}
