package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.MiuixScrollBehavior
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.basic.TextField
import top.yukonga.miuix.kmp.basic.FloatingActionButton
import top.yukonga.miuix.kmp.basic.FabPosition
import top.yukonga.miuix.kmp.preference.SwitchPreference
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme
import com.xzakota.hyper.notification.focus.example.core.NotificationUtils
import com.xzakota.hyper.notification.focus.example.ui.utils.pageContentPadding
import com.xzakota.hyper.notification.focus.example.ui.utils.pageScrollModifiers

@Composable
fun PagerV3Params(
    state: NotificationState,
    outerPadding: PaddingValues
) {
    val context = LocalContext.current
    val topAppBarScrollBehavior = MiuixScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                color = MiuixTheme.colorScheme.surface,
                title = "超级岛参数",
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
        item(key = "v3_header") {
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                SwitchPreference(
                    title = "启用超级岛",
                    checked = state.enableIsland,
                    onCheckedChange = { 
                        state.enableIsland = it
                        if (!it) {
                            state.dismissIslandVal = true
                        } else {
                            state.dismissIslandVal = false
                        }
                    }
                )
                if (state.enableIsland) {
                    OverlayDropdownPreference(
                        title = "大岛左侧",
                        items = listOf("imageTextInfoLeft", "imageTextInfoLeft5"),
                        selectedIndex = if (state.islandLeftSelection == "imageTextInfoLeft5") 1 else 0,
                        onSelectedIndexChange = { index ->
                            if (index == 1) {
                                state.islandLeftSelection = "imageTextInfoLeft5"
                                state.showIslandLeftInfo = true
                            } else {
                                state.islandLeftSelection = "imageTextInfoLeft"
                                state.showIslandLeftInfo = true
                            }
                        }
                    )
                    OverlayDropdownPreference(
                        title = "大岛右侧",
                        items = listOf("无", "imageTextInfoRight", "imageTextInfoRight3", "textInfo", "fixedWidthDigitInfo", "progressTextInfo"),
                        selectedIndex = when (state.islandRightSelection) {
                            "imageTextInfoRight" -> 1
                            "imageTextInfoRight3" -> 2
                            "textInfo" -> 3
                            "fixedWidthDigitInfo" -> 4
                            "progressTextInfo" -> 5
                            else -> 0
                        },
                        onSelectedIndexChange = { index ->
                            when (index) {
                                1 -> {
                                    state.islandRightSelection = "imageTextInfoRight"
                                    state.showIslandRightInfo = true
                                }
                                2 -> {
                                    state.islandRightSelection = "imageTextInfoRight3"
                                    state.showIslandRightInfo = true
                                }
                                3 -> {
                                    state.islandRightSelection = "textInfo"
                                    state.showIslandRightInfo = true
                                }
                                4 -> {
                                    state.islandRightSelection = "fixedWidthDigitInfo"
                                    state.showIslandRightInfo = true
                                }
                                5 -> {
                                    state.islandRightSelection = "progressTextInfo"
                                    state.showIslandRightInfo = true
                                }
                                else -> {
                                    state.islandRightSelection = "无"
                                    state.showIslandRightInfo = false
                                }
                            }
                        }
                    )
                    OverlayDropdownPreference(
                        title = "小岛组件",
                        items = listOf("无", "picInfo", "combinePicInfo"),
                        selectedIndex = when (state.islandSmallSelection) {
                            "picInfo" -> 1
                            "combinePicInfo" -> 2
                            else -> 0
                        },
                        onSelectedIndexChange = { index ->
                            when (index) {
                                1 -> {
                                    state.islandSmallSelection = "picInfo"
                                    state.showIslandSmallInfo = true
                                }
                                2 -> {
                                    state.islandSmallSelection = "combinePicInfo"
                                    state.showIslandSmallInfo = true
                                }
                                else -> {
                                    state.islandSmallSelection = "无"
                                    state.showIslandSmallInfo = false
                                }
                            }
                        }
                    )
                    val islandPropertyItems = listOf("以展示信息为主 (1)", "以操作为主 (2)")
                    val islandPropertySelectedIndex = if (state.islandPropertyVal) 1 else 0
                    OverlayDropdownPreference(
                        title = "islandProperty",
                        items = islandPropertyItems,
                        selectedIndex = islandPropertySelectedIndex,
                        onSelectedIndexChange = { index ->
                            state.islandPropertyVal = (index == 1)
                        }
                    )
                    SwitchPreference(
                        title = "islandOrder",
                        summary = "通知更新且摘要态隐藏时，是否更新岛的全局排序",
                        checked = state.islandOrderVal,
                        onCheckedChange = { state.islandOrderVal = it }
                    )
                    TextField(
                        value = state.islandTimeoutText,
                        onValueChange = { state.islandTimeoutText = it },
                        label = "islandTimeout (岛自动消失时长，单位: s)",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    TextField(
                        value = state.islandHighlightColor,
                        onValueChange = { state.islandHighlightColor = it },
                        label = "highlightColor (文字强调色，Hex)",
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                    SwitchPreference(
                        title = "shareData (拖拽分享)",
                        checked = state.showShareData,
                        onCheckedChange = { state.showShareData = it }
                    )
                }
            }
        }

        if (state.enableIsland) {
            // 1. 左侧组件
            if (state.showIslandLeftInfo) {
                item(key = "v3_leftInfo") {
                    SectionImageTextInfoLeft(state)
                }
            }

            // 2. 右侧组件
            if (state.showIslandRightInfo) {
                item(key = "v3_rightInfo_${state.islandRightSelection}") {
                    when (state.islandRightSelection) {
                        "textInfo" -> SectionTextInfo(state)
                        "fixedWidthDigitInfo" -> SectionFixedWidthDigitInfo(state)
                        "progressTextInfo" -> SectionProgressTextInfo(state)
                        else -> SectionImageTextInfoRight(state)
                    }
                }
            }

            // 3. 小岛组件
            if (state.showIslandSmallInfo) {
                item(key = "v3_smallInfo_${state.islandSmallSelection}") {
                    when (state.islandSmallSelection) {
                        "picInfo" -> SectionSmallPicInfo(state)
                        "combinePicInfo" -> SectionSmallCombinePicInfo(state)
                    }
                }
            }

            // 4. 拖拽分享数据组件
            if (state.showShareData) {
                item(key = "v3_shareData") {
                    SectionShareData(
                        shareTitle = state.shareTitle,
                        onShareTitleChange = { state.shareTitle = it },
                        shareContent = state.shareContent,
                        onShareContentChange = { state.shareContent = it },
                        sharePic = state.sharePic,
                        onSharePicChange = { state.sharePic = it },
                        shareContentText = state.shareContentText,
                        onShareContentTextChange = { state.shareContentText = it },
                        sharePicUrl = state.sharePicUrl,
                        onSharePicUrlChange = { state.sharePicUrl = it }
                    )
                }
            }
        }
    }
}
}
}