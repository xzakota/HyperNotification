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
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference

import com.xzakota.hyper.notification.focus.example.core.ImagePickerAndProcessor

@Composable
fun SectionBaseInfo(
    state: NotificationState
) {
    Column {
        SmallTitle(text = "type (文本组件类型)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            OverlayDropdownPreference(
                title = "type",
                summary = "1: 小字在上 / 2: 大字在上",
                items = listOf("1", "2"),
                selectedIndex = if (state.baseTypeVal) 1 else 0,
                onSelectedIndexChange = { state.baseTypeVal = (it == 1) }
            )
        }

        SmallTitle(text = "title (主要文本1)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.baseTitle,
                onValueChange = { state.baseTitle = it },
                label = "title",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorTitle,
                onValueChange = { state.baseColorTitle = it },
                label = "colorTitle (Hex, e.g. #006EFF)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorTitleDark,
                onValueChange = { state.baseColorTitleDark = it },
                label = "colorTitleDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "content (次要文本1)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.baseContent,
                onValueChange = { state.baseContent = it },
                label = "content",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorContent,
                onValueChange = { state.baseColorContent = it },
                label = "colorContent (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorContentDark,
                onValueChange = { state.baseColorContentDark = it },
                label = "colorContentDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "subTitle (主要文本2)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.baseSubTitle,
                onValueChange = { state.baseSubTitle = it },
                label = "subTitle",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorSubTitle,
                onValueChange = { state.baseColorSubTitle = it },
                label = "colorSubTitle (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorSubTitleDark,
                onValueChange = { state.baseColorSubTitleDark = it },
                label = "colorSubTitleDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "subContent (次要文本2)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.baseSubContent,
                onValueChange = { state.baseSubContent = it },
                label = "subContent",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorSubContent,
                onValueChange = { state.baseColorSubContent = it },
                label = "colorSubContent (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorSubContentDark,
                onValueChange = { state.baseColorSubContentDark = it },
                label = "colorSubContentDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "extraTitle (补充文本)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.baseExtraTitle,
                onValueChange = { state.baseExtraTitle = it },
                label = "extraTitle",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorExtraTitle,
                onValueChange = { state.baseColorExtraTitle = it },
                label = "colorExtraTitle (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorExtraTitleDark,
                onValueChange = { state.baseColorExtraTitleDark = it },
                label = "colorExtraTitleDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "specialTitle (特殊标签)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = state.baseSpecialTitle,
                onValueChange = { state.baseSpecialTitle = it },
                label = "specialTitle",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorSpecialTitle,
                onValueChange = { state.baseColorSpecialTitle = it },
                label = "colorSpecialTitle (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorSpecialTitleDark,
                onValueChange = { state.baseColorSpecialTitleDark = it },
                label = "colorSpecialTitleDark (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            TextField(
                value = state.baseColorSpecialBg,
                onValueChange = { state.baseColorSpecialBg = it },
                label = "colorSpecialBg (Hex)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        SmallTitle(text = "其它配置")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            ImagePickerPreference(
                title = "picFunction",
                summary = "资源标识 (建议 80*80px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.BASE_PIC_FUNCTION,
                currentPath = state.basePicFunction,
                onPathChange = { state.basePicFunction = it }
            )
            TextField(
                value = state.businessText,
                onValueChange = { state.businessText = it },
                label = "business (业务运营场景, 例如 taxi)",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
            )
            SwitchPreference(
                title = "showDivider",
                summary = "大字间的分割符",
                checked = state.baseShowDividerVal,
                onCheckedChange = { state.baseShowDividerVal = it }
            )
            SwitchPreference(
                title = "showContentDivider",
                summary = "小字间的分割符",
                checked = state.baseShowContentDividerVal,
                onCheckedChange = { state.baseShowContentDividerVal = it }
            )
            SwitchPreference(
                title = "setMarginTop",
                summary = "通知卡片顶部预留微小的边距空白",
                checked = state.baseSetMarginTopVal,
                onCheckedChange = { state.baseSetMarginTopVal = it }
            )
            SwitchPreference(
                title = "setMarginBottom",
                summary = "通知卡片底部预留微小的边距空白",
                checked = state.baseSetMarginBottomVal,
                onCheckedChange = { state.baseSetMarginBottomVal = it }
            )
        }
    }
}
