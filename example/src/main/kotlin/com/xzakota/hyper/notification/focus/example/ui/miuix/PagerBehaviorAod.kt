package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.MiuixScrollBehavior
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.TextField
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference
import top.yukonga.miuix.kmp.preference.SwitchPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme
import com.xzakota.hyper.notification.focus.example.ui.utils.pageContentPadding
import com.xzakota.hyper.notification.focus.example.ui.utils.pageScrollModifiers

import com.xzakota.hyper.notification.focus.example.core.ImagePickerAndProcessor

@Composable
fun PagerBehaviorAod(
    state: NotificationState,
    outerPadding: PaddingValues
) {
    val topAppBarScrollBehavior = MiuixScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                color = MiuixTheme.colorScheme.surface,
                title = "更多属性数据",
                scrollBehavior = topAppBarScrollBehavior,
            )
        }
    ) { innerPadding ->
        val contentPadding = pageContentPadding(
            innerPadding = innerPadding,
            outerPadding = outerPadding,
            isWideScreen = false,
            extraStart = 0.dp,
            extraEnd = 0.dp,
        )

        Box {
            LazyColumn(
                modifier = Modifier.pageScrollModifiers(
                    enableScrollEndHaptic = true,
                    showTopAppBar = true,
                    topAppBarScrollBehavior = topAppBarScrollBehavior,
                ),
                contentPadding = contentPadding
            ) {
                item {
                    SmallTitle(text = "通知属性数据")
                }
                item {
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 12.dp)
                            .fillMaxWidth()
                    ) {
                        SwitchPreference(
                            title = "islandFirstFloat",
                            checked = state.islandFirstFloatVal,
                            onCheckedChange = { state.islandFirstFloatVal = it },
                            summary = "首次出现自动显示展开态"
                        )
                        SwitchPreference(
                            title = "enableFloat",
                            checked = state.enableFloatVal,
                            onCheckedChange = { state.enableFloatVal = it },
                            summary = "更新时自动显示展开态"
                        )
                        TextField(
                            value = state.timeoutText,
                            onValueChange = { state.timeoutText = it },
                            label = "timeout (消失时间，单位: min)",
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                        SwitchPreference(
                            title = "updatable",
                            checked = state.updatableVal,
                            onCheckedChange = { state.updatableVal = it },
                            summary = "是否为持续性通知"
                        )
                        
                        val reopenItems = listOf("close (不显示)", "reopen (再次显示)")
                        val reopenSelectedIndex = if (state.reopenText == "reopen") 1 else 0
                        OverlayDropdownPreference(
                            title = "reopen",
                            summary = "相同ID被cancel后再次发送是否显示",
                            items = reopenItems,
                            selectedIndex = reopenSelectedIndex,
                            onSelectedIndexChange = { index ->
                                state.reopenText = if (index == 1) "reopen" else "close"
                            }
                        )
                        
                        SwitchPreference(
                            title = "filterWhenNoPermission",
                            checked = state.filterWhenNoPermissionVal,
                            onCheckedChange = { state.filterWhenNoPermissionVal = it },
                            summary = "焦点通知权限被关闭时退化为普通通知的处理方式"
                        )
                        SwitchPreference(
                            title = "outEffectSrc",
                            checked = state.outEffectSrc.isNotEmpty(),
                            onCheckedChange = { checked ->
                                state.outEffectSrc = if (checked) "glow" else ""
                            },
                            summary = "超级岛展开态环绕光效"
                        )
                    }
                }
                item {
                    SmallTitle(text = "息屏显示数据")
                }
                item {
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 12.dp)
                            .fillMaxWidth()
                    ) {
                        TextField(
                            value = state.aodTitleText,
                            onValueChange = { state.aodTitleText = it },
                            label = "aodTitle (息屏焦点通知显示文案)",
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                        ImagePickerPreference(
                            title = "aodPic",
                            summary = "息屏模式图标 (建议 88*88px)",
                            imageSpec = ImagePickerAndProcessor.ImageSpec.AOD_PIC,
                            currentPath = state.aodPicText,
                            onPathChange = { state.aodPicText = it }
                        )
                    }
                }
                item {
                    SmallTitle(text = "状态栏焦点信息数据")
                }
                item {
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 12.dp)
                            .fillMaxWidth()
                    ) {
                        TextField(
                            value = state.tickerText,
                            onValueChange = { state.tickerText = it },
                            label = "ticker (OS2 焦点通知状态栏显示文案)",
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                        ImagePickerPreference(
                            title = "tickerPic",
                            summary = "状态栏图标 (建议 88*88px)",
                            imageSpec = ImagePickerAndProcessor.ImageSpec.TICKER_PIC,
                            currentPath = state.tickerPicText,
                            onPathChange = { state.tickerPicText = it }
                        )
                        ImagePickerPreference(
                            title = "tickerPicDark",
                            summary = "深色状态栏图标 (建议 88*88px)",
                            imageSpec = ImagePickerAndProcessor.ImageSpec.TICKER_PIC,
                            currentPath = state.tickerPicDark,
                            onPathChange = { state.tickerPicDark = it }
                        )
                    }
                }
            }
        }
    }
}
