package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.MiuixScrollBehavior
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.preference.SwitchPreference
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme
import com.xzakota.hyper.notification.focus.example.ui.utils.pageContentPadding
import com.xzakota.hyper.notification.focus.example.ui.utils.pageScrollModifiers

@Composable
fun PagerV2Params(
    state: NotificationState,
    outerPadding: PaddingValues
) {
    val topAppBarScrollBehavior = MiuixScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                color = MiuixTheme.colorScheme.surface,
                title = "焦点通知参数",
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
        item(key = "v2_header") {
            val coreStyles = listOf("none", "baseInfo", "chatInfo", "highlightInfo", "iconTextInfo", "coverInfo")
            val selectedIndex = when {
                state.showBaseInfo -> 1
                state.showChatInfo -> 2
                state.showHighlightInfo -> 3
                state.showIconTextInfo -> 4
                state.showCoverInfo -> 5
                else -> 0
            }
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                SwitchPreference(
                    title = "启用焦点通知",
                    checked = state.isShowNotificationVal,
                    onCheckedChange = { state.isShowNotificationVal = it },
                    summary = "关闭后焦点通知仅作为超级岛展开态展示，如果只想保留超级岛，就把通知组件全改为none"
                )
                OverlayDropdownPreference(
                    title = "通知上方左侧组件",
                    items = coreStyles,
                    selectedIndex = selectedIndex,
                    onSelectedIndexChange = { index ->
                        when (index) {
                            0 -> {
                                state.showBaseInfo = false
                                state.showChatInfo = false
                                state.showHighlightInfo = false
                                state.showIconTextInfo = false
                                state.showCoverInfo = false
                            }
                            1 -> state.showBaseInfo = true
                            2 -> state.showChatInfo = true
                            3 -> state.showHighlightInfo = true
                            4 -> state.showIconTextInfo = true
                            5 -> state.showCoverInfo = true
                        }
                    }
                )
                OverlayDropdownPreference(
                    title = "通知上方右侧组件",
                    items = listOf("none", "picInfo", "actions"),
                    selectedIndex = when {
                        state.showPicInfo -> 1
                        state.showActions -> 2
                        else -> 0
                    },
                    onSelectedIndexChange = { index ->
                        state.showPicInfo = (index == 1)
                        state.showActions = (index == 2)
                    }
                )
                OverlayDropdownPreference(
                    title = "通知下方组件",
                    items = listOf("none", "hintInfo", "progressInfo", "multiProgressInfo", "highlightInfoV3"),
                    selectedIndex = when {
                        state.showHintInfo -> 1
                        state.showProgressInfo -> 2
                        state.showMultiProgressInfo -> 3
                        state.showHighlightInfoV3 -> 4
                        else -> 0
                    },
                    onSelectedIndexChange = { index ->
                        state.showHintInfo = (index == 1)
                        state.showProgressInfo = (index == 2)
                        state.showMultiProgressInfo = (index == 3)
                        state.showHighlightInfoV3 = (index == 4)
                    }
                )
                SwitchPreference(
                    title = "bgInfo (通知背景组件)",
                    checked = state.showBgInfo,
                    onCheckedChange = { state.showBgInfo = it }
                )
            }
        }

        // 1. 上方左侧组件
        if (state.showBaseInfo) {
            item(key = "v2_baseInfo") {
                SectionBaseInfo(
                    state = state
                )
            }
        }

        if (state.showChatInfo) {
            item(key = "v2_chatInfo") {
                SectionChatInfo(
                    state = state
                )
            }
        }

        if (state.showHighlightInfo) {
            item(key = "v2_highlightInfo") {
                SectionHighlightInfo(
                    state = state
                )
            }
        }

        if (state.showIconTextInfo) {
            item(key = "v2_iconTextInfo") {
                SectionIconTextInfo(
                    state = state
                )
            }
        }

        if (state.showCoverInfo) {
            item(key = "v2_coverInfo") {
                SectionCoverInfo(
                    state = state
                )
            }
        }

        // 2. 上方右侧组件
        if (state.showPicInfo) {
            item(key = "v2_picInfo") {
                SectionPicInfo(
                    state = state
                )
            }
        }

        if (state.showActions) {
            item(key = "v2_actions") {
                SectionActions(
                    state = state
                )
            }
        }

        // 3. 下方组件
        if (state.showHintInfo) {
            item(key = "v2_hintInfo") {
                SectionHintInfo(
                    state = state
                )
            }
        }

        if (state.showProgressInfo) {
            item(key = "v2_progressInfo") {
                SectionProgressInfo(
                    state = state
                )
            }
        }

        if (state.showMultiProgressInfo) {
            item(key = "v2_multiProgressInfo") {
                SectionMultiProgressInfo(
                    state = state
                )
            }
        }

        if (state.showHighlightInfoV3) {
            item(key = "v2_highlightInfoV3") {
                SectionHighlightInfoV3(
                    state = state
                )
            }
        }

        // 4. 背景组件
        if (state.showBgInfo) {
            item(key = "v2_bgInfo") {
                SectionBgInfo(
                    state = state
                )
            }
        }
    }
}
}
}
