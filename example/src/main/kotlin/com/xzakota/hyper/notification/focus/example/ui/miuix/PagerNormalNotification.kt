package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import top.yukonga.miuix.kmp.theme.MiuixTheme
import com.xzakota.hyper.notification.focus.example.core.NotificationUtils
import com.xzakota.hyper.notification.focus.example.ui.utils.pageContentPadding
import com.xzakota.hyper.notification.focus.example.ui.utils.pageScrollModifiers

@Composable
fun PagerNormalNotification(
    state: NotificationState,
    outerPadding: PaddingValues
) {
    val context = LocalContext.current
    val topAppBarScrollBehavior = MiuixScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                color = MiuixTheme.colorScheme.surface,
                title = "普通通知参数",
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
            SmallTitle(text = "普通通知基本参数")
        }
        item {
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = state.normalTitle,
                    onValueChange = { state.normalTitle = it },
                    label = "通知标题 (Title)",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 12.dp)
                )
                TextField(
                    value = state.normalContent,
                    onValueChange = { state.normalContent = it },
                    label = "通知内容 (Content)",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
                )
            }
        }

    }
}
}
}

