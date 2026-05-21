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
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference
import top.yukonga.miuix.kmp.preference.SwitchPreference

import com.xzakota.hyper.notification.focus.example.core.ImagePickerAndProcessor

@Composable
fun SectionHintInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "hintInfo")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            val typeSelectedIndex = when (state.hintType) {
                "2" -> 1
                else -> 0
            }
            OverlayDropdownPreference(
                title = "type",
                items = listOf("单行内容 (1)", "双行内容 (2)"),
                selectedIndex = typeSelectedIndex,
                onSelectedIndexChange = { index ->
                    state.hintType = if (index == 1) "2" else "1"
                }
            )
        }

        if (state.hintType == "2") {
            // type 为 2 时，timer 和 title 二选一
            SmallTitle(text = "主要文本展示类型")
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                OverlayDropdownPreference(
                    title = "展示类型",
                    items = listOf("title (主要文本)", "timerInfo (时间计时器)"),
                    selectedIndex = if (state.showTimerInfo) 1 else 0,
                    onSelectedIndexChange = { index ->
                        state.showTimerInfo = index == 1
                    }
                )
            }

            if (!state.showTimerInfo) {
                SmallTitle(text = "title (主要文本 1)")
                Card(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .padding(bottom = 12.dp)
                        .fillMaxWidth()
                ) {
                    TextField(
                        value = state.hintTitle,
                        onValueChange = { state.hintTitle = it },
                        label = "title",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = state.hintColorTitle,
                        onValueChange = { state.hintColorTitle = it },
                        label = "colorTitle",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = state.hintColorTitleDark,
                        onValueChange = { state.hintColorTitleDark = it },
                        label = "colorTitleDark",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            } else {
                SectionTimerInfo(state = state)
            }
        } else {
            // type 为 1 时，timer 和 title 可以并存
            SmallTitle(text = "title (主要文本 1)")
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = state.hintTitle,
                    onValueChange = { state.hintTitle = it },
                    label = "title",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.hintColorTitle,
                    onValueChange = { state.hintColorTitle = it },
                    label = "colorTitle",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                TextField(
                    value = state.hintColorTitleDark,
                    onValueChange = { state.hintColorTitleDark = it },
                    label = "colorTitleDark",
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
                    title = "timerInfo",
                    checked = state.showTimerInfo,
                    onCheckedChange = { state.showTimerInfo = it }
                )
            }

            if (state.showTimerInfo) {
                SectionTimerInfo(state = state)
            }
        }

        SmallTitle(text = "subTitle (次要文本 2)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.hintSubTitle,
                onValueChange = { state.hintSubTitle = it },
                label = "subTitle",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.hintColorSubTitle,
                onValueChange = { state.hintColorSubTitle = it },
                label = "colorSubTitle",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.hintColorSubTitleDark,
                onValueChange = { state.hintColorSubTitleDark = it },
                label = "colorSubTitleDark",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "content (前置文本 1)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.hintContent,
                onValueChange = { state.hintContent = it },
                label = "content",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.hintColorContent,
                onValueChange = { state.hintColorContent = it },
                label = "colorContent",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.hintColorContentDark,
                onValueChange = { state.hintColorContentDark = it },
                label = "colorContentDark",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
        if (state.hintType == "1") {
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = state.hintColorContentBg,
                    onValueChange = { state.hintColorContentBg = it },
                    label = "colorContentBg (图文特殊标签背景色 Hex)",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                )
                ImagePickerPreference(
                    title = "picContent",
                    summary = "图文特殊标签图标 (建议 96*96px)",
                    imageSpec = ImagePickerAndProcessor.ImageSpec.HINT_PIC_CONTENT,
                    currentPath = state.hintPicContent,
                    onPathChange = { state.hintPicContent = it }
                )
            }
        }


        SmallTitle(text = "subContent (前置文本 2)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.hintSubContent,
                onValueChange = { state.hintSubContent = it },
                label = "subContent",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.hintColorSubContent,
                onValueChange = { state.hintColorSubContent = it },
                label = "colorSubContent",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.hintColorSubContentDark,
                onValueChange = { state.hintColorSubContentDark = it },
                label = "colorSubContentDark",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        // 按钮动作组件 (actionInfo) 无论是 type 为 1 还是 2，均支持嵌入配置
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            SwitchPreference(
                title = "actionInfo",
                checked = state.showActionInfo,
                onCheckedChange = { state.showActionInfo = it }
            )
        }

        if (state.showActionInfo) {
            SectionActionInfo(state = state)
        }
    }
}
